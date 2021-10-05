package com.notificationsender.event.provider;

import com.notificationsender.model.NotificationReceiver;
import com.notificationsender.model.NotificationTypeEnum;

public interface NotificationProviderFactory {
  <T extends NotificationReceiver> NotificationProvider<T> getNotificationProvider(NotificationTypeEnum type);
}
