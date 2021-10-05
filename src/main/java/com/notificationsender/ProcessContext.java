package com.notificationsender;

import com.notificationsender.model.AssignmentTask;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ProcessContext {
  private String jobId;
  private String description;
  private AssignmentTask task;
}
