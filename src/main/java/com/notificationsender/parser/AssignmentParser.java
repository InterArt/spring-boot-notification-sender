package com.notificationsender.parser;

import com.notificationsender.model.AssignmentTask;
import com.notificationsender.model.Customer;
import com.notificationsender.model.Employee;
import com.notificationsender.model.EventTypeEnum;
import com.notificationsender.model.TaskTypeEnum;
import com.notificationsender.model.Template;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;

@Component
public class AssignmentParser {

  private static final Pattern regex = Pattern.compile("\\{(.*?)\\}");

  public AssignmentTask parse(String str) {
    try {
      var stepName = str.split("=")[0].trim();
      var values = str.substring(str.indexOf("{") + 1, str.indexOf("}")).split(",");
      var type = initType(values[0]);
      var employee = initEmployee(values[1]);
      var customer = initCustomer(values[2]);
      var delay = initDelayInSecond(values[3]);
      var notificationType = initNotificationType(values[4]);
      var template = initTemplate(values[5]);

      return AssignmentTask.builder()
          .customer(customer)
          .employee(employee)
          .delayInSeconds(delay)
          .eventType(notificationType)
          .taskType(type)
          .template(template)
          .stepId(stepName)
          .description(str)
          .build();

    } catch (Exception ex) {
      throw new RuntimeException("invalid data ===>" + str);
    }
  }

  private Template initTemplate(String value) {
    return null;
  }

  private EventTypeEnum initNotificationType(String value) {
    return null;
  }

  private long initDelayInSecond(String value) {
    return 0;
  }

  private Customer initCustomer(String value) {
    return null;
  }

  private Employee initEmployee(String value) {
    return null;
  }

  private TaskTypeEnum initType(String value) {
    return null;
  }
}
