package com.notificationsender.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Customer {
  private String firstName;
  private String lastName;
  private String phoneNumber;
  private String email;

}
