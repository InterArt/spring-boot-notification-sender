package com.notificationsender.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class SmsReceiver implements NotificationReceiver{
  private String phoneNumber;
}
