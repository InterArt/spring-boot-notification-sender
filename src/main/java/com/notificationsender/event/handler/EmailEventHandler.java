package com.notificationsender.event.handler;

import com.notificationsender.model.EmailReceiver;
import com.notificationsender.model.EventData;
import java.io.StringWriter;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("EMAIL")
public class EmailEventHandler implements MessagingEventHandler<SimpleEmailEvent, EmailReceiver>{

  @Autowired
  private VelocityEngine velocityEngine;

  @Override
  public EventData<EmailReceiver> handle(SimpleEmailEvent simpleEmailEvent) {
    var message = getContent(simpleEmailEvent);
    return new EventData<>(
        EmailReceiver.builder()
            .emailAddress(simpleEmailEvent.getEmailAddress())
            .build(), message
    );
  }

  public String getContent(SimpleEmailEvent simpleEmailEvent) {
    VelocityContext context = new VelocityContext();
    context.put("customerFirstName", simpleEmailEvent.getCustomerFirstName());
    context.put("employeeName", simpleEmailEvent.getEmployeeName());
    StringWriter stringWriter = new StringWriter();
    velocityEngine.mergeTemplate(simpleEmailEvent.getTemplate(), "UTF-8", context, stringWriter);
    String text = stringWriter.toString();
    return text;
  }
}
