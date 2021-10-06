package com.notificationsender.scheduler;

import java.util.Timer;

public class TaskSteps {
  private String processId;
  private Timer timer;
  private int order;

  public Timer getTimer() {
    return timer;
  }
}
