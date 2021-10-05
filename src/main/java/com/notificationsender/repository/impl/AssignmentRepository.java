package com.notificationsender.repository.impl;

import com.notificationsender.model.AssignmentTask;
import com.notificationsender.repository.mock.AssignmentMockDataProvider;
import com.notificationsender.repository.IAssignmentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AssignmentRepository implements IAssignmentRepository {

  @Autowired
  private AssignmentMockDataProvider assignmentMockDataProvider;

  @Override
  public List<AssignmentTask> loadAssignmentTasks() {
    return assignmentMockDataProvider.loadAssignmentTasks();
  }
}
