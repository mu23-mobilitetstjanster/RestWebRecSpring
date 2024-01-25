package com.example.restwebrecspring.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data // getters and setters for all member properties
@AllArgsConstructor // One constructor with all the member properties
public class Payment {

  private String title;
  private int sum;
}
