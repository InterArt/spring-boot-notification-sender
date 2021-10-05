package com.notificationsender.event.handler;

import com.notificationsender.model.EventTypeEnum;
import com.notificationsender.model.NotificationReceiver;

public interface EventHandlerFactory {
  <T extends MessagingEvent, R extends NotificationReceiver> MessagingEventHandler<T, R> getEventHandler(
      EventTypeEnum event);
}
