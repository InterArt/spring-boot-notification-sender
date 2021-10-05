package com.notificationsender.repository;

import com.notificationsender.model.AssignmentTask;
import java.util.List;

public interface IAssignmentRepository {

  List<AssignmentTask> loadAssignmentTasks();
}
