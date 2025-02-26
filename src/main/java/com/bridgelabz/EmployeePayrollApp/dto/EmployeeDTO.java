package com.bridgelabz.EmployeePayrollApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
 private String name;
 private double salary;

     @Override
    public String toString() {
        return "Employee : " +
                "name='" + name + '\'' +
                ", salary=" + salary ;
    }
}
