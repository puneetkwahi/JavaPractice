package com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String name;
    private String department;
    private Integer salary;
    private List<Integer> phoneNumbers;
}
