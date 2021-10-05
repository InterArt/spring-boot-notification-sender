package com.notificationsender.model;

import java.util.Map;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AssignmentTask {
  private TaskTypeEnum taskType;
  private Employee employee;
  private Customer customer;
  private EventTypeEnum eventType;
  private int delayInSeconds;
  private Template template;

  public Map<String, Object> toMap() {
    return null;
  }
}
