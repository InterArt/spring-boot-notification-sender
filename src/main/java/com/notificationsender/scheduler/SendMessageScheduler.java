package com.notificationsender.scheduler;

import com.notificationsender.ProcessContext;
import com.notificationsender.model.AssignmentTask;
import com.notificationsender.event.handler.EventHandlerFactory;
import com.notificationsender.event.handler.MessagingEvent;
import com.notificationsender.event.handler.SimpleEmailEvent;
import com.notificationsender.event.handler.SimpleSMSEvent;
import com.notificationsender.model.NotificationTypeEnum;
import com.notificationsender.event.provider.NotificationProviderFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class SendMessageScheduler {

  @Autowired
  private EventHandlerFactory eventHandlerFactory;

  @Autowired
  private NotificationProviderFactory notificationProviderFactory;

  private final Map<String, Timer> timerMap = new HashMap<>();

  public void schedule(ProcessContext processContext) {
    var delay = processContext.getTask().getDelayInSeconds();
    Timer timer = new Timer(processContext.getDescription());
    timer.schedule(new TimerTask() {
      @Override
      public void run() {
        var eventType = processContext.getTask().getEventType();
        var senderType = NotificationTypeEnum.getNotificationFor(processContext.getTask().getEventType());
        var handler = eventHandlerFactory.getEventHandler(eventType);
        var buildEvent = buildEvent(processContext.getTask());
        var eventData = handler.handle(buildEvent);
        var notificationReceiver = eventData.getReceiver();
        notificationProviderFactory
            .getNotificationProvider(senderType)
            .sendTo(notificationReceiver, eventData.getMessage());
      }
    }, delay);
    timerMap.put(processContext.getJobId(), timer);
  }

  private void cancelTask(String taskId) {
    var timer = timerMap.get(taskId);
    if (timer == null) {
      log.error("Timer not found for id {} ", taskId);
      return;
    }

    timer.cancel();
    timer.purge();
  }


  private <T extends MessagingEvent> T buildEvent(AssignmentTask task) {
    return switch (task.getEventType()) {
      case sms -> buildSmsEvent(task);
      case email -> buildEmailEvent(task);
    };
  }

  private <T extends MessagingEvent> T buildSmsEvent(AssignmentTask task) {
    SimpleSMSEvent event = new SimpleSMSEvent();
    event.setTemplate(task.getTemplate().getPath());
    event.setPhoneNumber(task.getCustomer().getPhoneNumber());
    event.setCustomerFirstName(task.getCustomer().getFirstName());
    event.setEmployeeName(task.getEmployee().getName());
    return (T) event;
  }

  private <T extends MessagingEvent> T buildEmailEvent(AssignmentTask task) {
    SimpleEmailEvent event = new SimpleEmailEvent();
    event.setTemplate(task.getTemplate().getPath());
    event.setEmailAddress(task.getCustomer().getEmail());
    event.setCustomerFirstName(task.getCustomer().getFirstName());
    event.setEmployeeName(task.getEmployee().getName());
    return (T) event;
  }
}
