package com.bridgelabz.EmployeePayrollApp.controller;

import com.bridgelabz.EmployeePayrollApp.dto.EmployeeDTO;
import com.bridgelabz.EmployeePayrollApp.model.Employee;
import com.bridgelabz.EmployeePayrollApp.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j

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
    public EmployeeDTO addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        log.debug("Received Employee Data: {}", employeeDTO);
        EmployeeDTO savedEmployee= employeeService.addEmployee(employeeDTO);
        log.info("Employee created successfully with ID: {}", savedEmployee.getName());
        return savedEmployee;
    }


    @PutMapping("/update/{id}")
    public EmployeeDTO updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
        log.info("Fetching employee with ID: {}", id);
        EmployeeDTO employee= employeeService.updateEmployee(id, employeeDTO);
        log.info("Retrieved Employee: {}", employee);
        return  employee;
    }


    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        log.warn("Received request to delete employee with ID: {}", id);
        String deleteEmployee= employeeService.deleteEmployee(id) ? "Employee deleted successfully" : "Employee not found";
        log.warn("Employee with ID: {} deleted successfully", id);
        return deleteEmployee;
}

    @GetMapping("/details")
    public List<Employee> getAllEmployees() {
        log.info("Fetching all employees");
        List<Employee> employees = employeeService.getAllEmployees();
        log.info("Total Employees Retrieved: {}", employees.size());
        return employeeService.getAllEmployees();
    }


    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        log.info("Fetching employee with ID : {}", id);
        return employeeService.getEmployeeById(id);
    }

}
