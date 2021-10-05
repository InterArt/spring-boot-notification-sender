package com.notificationsender.event.handler;

import com.notificationsender.model.EventData;
import com.notificationsender.model.NotificationReceiver;

public interface MessagingEventHandler<T extends MessagingEvent, R extends NotificationReceiver> {
  EventData<R> handle(T t);
}
