package com.notificationsender.event.handler;

import com.notificationsender.model.EventData;
import com.notificationsender.model.SmsReceiver;
import java.io.StringWriter;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("SMS")
public class SMSEventHandler implements MessagingEventHandler<SimpleSMSEvent, SmsReceiver>{

  @Autowired
  private VelocityEngine velocityEngine;

  @Override
  public EventData<SmsReceiver> handle(SimpleSMSEvent simpleSMSEvent) {
    var message = getContent(simpleSMSEvent);
    return new EventData<>(
      SmsReceiver.builder()
          .phoneNumber(simpleSMSEvent.getPhoneNumber())
          .build(), message
    );
  }

  public String getContent(SimpleSMSEvent simpleSMSEvent) {
    VelocityContext context = new VelocityContext();
    context.put("customerFirstName", simpleSMSEvent.getCustomerFirstName());
    context.put("employeeName", simpleSMSEvent.getEmployeeName());
    StringWriter stringWriter = new StringWriter();
    velocityEngine.mergeTemplate(simpleSMSEvent.getTemplate(), "UTF-8", context, stringWriter);
    String text = stringWriter.toString();
    return text;
  }
}
