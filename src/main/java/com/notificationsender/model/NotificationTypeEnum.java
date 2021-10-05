package com.notificationsender.model;

public enum NotificationTypeEnum {
  SMS_PROVIDER,
  EMAIL_PROVIDER;

  public static NotificationTypeEnum getNotificationFor(EventTypeEnum eventType) {
    return switch (eventType) {
      case sms -> SMS_PROVIDER;
      case email -> EMAIL_PROVIDER;
      default -> throw new IllegalArgumentException("Notification provider not found for type = " + eventType.name());
    };
  }
}
