package com.notificationsender.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class EmailReceiver implements NotificationReceiver{
  private String emailAddress;
}
