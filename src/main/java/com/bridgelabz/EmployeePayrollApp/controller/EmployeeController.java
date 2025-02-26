package com.bridgelabz.EmployeePayrollApp.controller;

import com.bridgelabz.EmployeePayrollApp.dto.EmployeeDTO;
import com.bridgelabz.EmployeePayrollApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @GetMapping("/welcome")
    public String welcomeMessage(){
        return "Welcome to employee payroll application.";
    }
    @PostMapping("/add")
    public String addEmployee(@RequestBody EmployeeDTO employee) {
        return employee.toString();
    }

    @PutMapping("/update")
    public String updateEmployee(){
        return "Employee updated succesfully";
    }
    @DeleteMapping("/delete")
    public String deleteEmployee(){
        return "Employee deleted succesfully";
    }
    @GetMapping("/details")
    public String getEmployeeDetails(){
        return employeeService.getEmployeeDetails().toString();
    }
}
