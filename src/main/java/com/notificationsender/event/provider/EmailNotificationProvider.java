package com.notificationsender.event.provider;

import com.notificationsender.model.EmailReceiver;
import org.springframework.stereotype.Component;

@Component("EMAIL_PROVIDER")
public class EmailNotificationProvider implements NotificationProvider<EmailReceiver> {

  @Override
  public void sendTo(EmailReceiver receiver, String message) {

  }
}
