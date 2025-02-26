package com.bridgelabz.EmployeePayrollApp.controller;

import com.bridgelabz.EmployeePayrollApp.dto.EmployeeDTO;
import com.bridgelabz.EmployeePayrollApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return employeeService.addEmployee(employee);
    }

    @PutMapping("/update/{name}")
    public String updateEmployee(@PathVariable String name,@RequestBody EmployeeDTO employee){
        return employeeService.updateEmployeeByName(name,employee);
    }
    @DeleteMapping("/delete/{name}")
    public String deleteEmployee(@PathVariable String name){
        return employeeService.deleteEmployeeByName(name);
    }
    @GetMapping("/details")
    public String getEmployeeDetails(){
        String allEmployees="";
        List<EmployeeDTO> allEmployeeList=employeeService.getAllEmployee();
        for(EmployeeDTO employee:allEmployeeList){
            allEmployees+=employee.toString()+"\n";
        }
        return allEmployees;
    }
    @GetMapping("/employeeDetail/{name}")
    public String employeeDetail(@PathVariable String name){
        return employeeService.getEmployeeByName(name);
    }
}
