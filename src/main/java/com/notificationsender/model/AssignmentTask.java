package com.notificationsender.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AssignmentTask {
  private TaskTypeEnum taskType;
  private Employee employee;
  private Customer customer;
  private EventTypeEnum eventType;
  private long delayInSeconds;
  private Template template;
  private String stepId;
  private String description;
}
