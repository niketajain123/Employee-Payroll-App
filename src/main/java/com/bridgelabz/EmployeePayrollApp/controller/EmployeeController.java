package com.bridgelabz.EmployeePayrollApp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @GetMapping("/welcome")
    public String welcomeMessage(){
        return "Welcome to employee payroll application.";
    }
    @PostMapping("/add")
    public String addEmployee(){
        return "Employee added succesfully";
    }
    @PutMapping("/update")
    public String updateEmployee(){
        return "Employee updated succesfully";
    }
    @DeleteMapping("/delete")
    public String deleteEmployee(){
        return "Employee deleted succesfully";
    }
}
