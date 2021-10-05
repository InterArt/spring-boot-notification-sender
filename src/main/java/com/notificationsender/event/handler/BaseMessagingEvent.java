package com.notificationsender.event.handler;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseMessagingEvent implements MessagingEvent{
  protected String customerFirstName;
  protected String employeeName;
  protected String template;
}
