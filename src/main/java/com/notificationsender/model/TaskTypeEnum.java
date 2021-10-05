package com.notificationsender.model;

public enum TaskTypeEnum {
  SEND_MESSAGE ("sendmessage");

  TaskTypeEnum(String type) {
    this.type = type;
  }

  private final String type;
}
