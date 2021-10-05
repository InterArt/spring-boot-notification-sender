package com.notificationsender.event.handler;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimpleEmailEvent extends BaseMessagingEvent {
  private String emailAddress;
}
