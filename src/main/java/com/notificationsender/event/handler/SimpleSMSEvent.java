package com.notificationsender.event.handler;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimpleSMSEvent extends BaseMessagingEvent {
  private String phoneNumber;
}
