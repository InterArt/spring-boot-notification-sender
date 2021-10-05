package com.notificationsender.event.provider;

import com.notificationsender.model.NotificationReceiver;

public interface NotificationProvider<T extends NotificationReceiver> {
  void sendTo(T receiver, String message);
}
