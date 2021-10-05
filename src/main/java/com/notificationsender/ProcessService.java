package com.notificationsender;

import com.notificationsender.repository.IAssignmentRepository;
import com.notificationsender.scheduler.SendMessageScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcessService {
  @Autowired
  private SendMessageScheduler scheduler;
  @Autowired
  private IAssignmentRepository assignmentRepository;


  public void doProcess() {
    assignmentRepository.loadAssignmentTasks()
        .forEach(assignmentTask -> {
          var context = ProcessContext.builder().build();
          scheduler.schedule(context);
        });
  }
}
