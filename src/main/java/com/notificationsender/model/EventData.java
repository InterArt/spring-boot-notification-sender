package com.notificationsender.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
@Getter
public class EventData<T extends NotificationReceiver> {
    private T receiver;
    private String message;

}
