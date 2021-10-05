package com.notificationsender.event.provider;

import com.notificationsender.model.SmsReceiver;
import org.springframework.stereotype.Component;

@Component("SMS_PROVIDER")
public class SmsNotificationProvider implements NotificationProvider<SmsReceiver> {

  @Override
  public void sendTo(SmsReceiver receiver, String message) {

  }
}
