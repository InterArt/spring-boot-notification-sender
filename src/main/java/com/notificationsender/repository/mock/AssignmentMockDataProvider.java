package com.notificationsender.repository.mock;

import com.notificationsender.model.AssignmentTask;
import com.notificationsender.parser.AssignmentParser;
import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AssignmentMockDataProvider {

  @Autowired
  private AssignmentParser parser;

  private static final List<String> INPUT_DATA = new ArrayList<>();
  static {
    INPUT_DATA.add("S1 =  {\"sendmessage\", \"EmployeeA\", \"John Doe\" or 1234,  5 min,  email, Template1 }");
    INPUT_DATA.add("S2 =  {\"sendmessage\", \"EmployeeA\", \"John Doe\" or 1234,  15 min,  sms, Template2 }");
    INPUT_DATA.add("S3 =  {\"sendmessage\", \"EmployeeA\", \"John Doe\" or 1234,  30 min,  sms, Template3 }");
    INPUT_DATA.add("S4 =  {\"sendmessage\", \"EmployeeA\", \"John Doe\" or 1234,  60 min,  sms, Template3 }");
  }

  public List<AssignmentTask> loadAssignmentTasks() {
    return  INPUT_DATA.stream().map( data -> parser.parse(data)).collect(Collectors.toList());
  }
}
