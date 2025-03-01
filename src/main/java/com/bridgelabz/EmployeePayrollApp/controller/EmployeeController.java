package com.bridgelabz.EmployeePayrollApp.controller;

import com.bridgelabz.EmployeePayrollApp.dto.EmployeeDTO;
import com.bridgelabz.EmployeePayrollApp.model.Employee;
import com.bridgelabz.EmployeePayrollApp.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @GetMapping("/welcome")
    public ResponseEntity<String> welcomeMessage() {
        return ResponseEntity.ok("Welcome to Employee Payroll App!");
    }

    @PostMapping("/add")
    public ResponseEntity<EmployeeDTO> addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        log.debug("Received Employee Data: {}", employeeDTO);
        EmployeeDTO savedEmployee = employeeService.addEmployee(employeeDTO);
        log.info("Employee created successfully with Name: {}", savedEmployee.getName());
        return ResponseEntity.ok(savedEmployee);
    }



    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeDTO employeeDTO) {
        log.info("Updating employee with ID: {}", id);
        EmployeeDTO updatedEmployee = employeeService.updateEmployee(id, employeeDTO);
        log.info("Employee updated successfully: {}", updatedEmployee);
        return ResponseEntity.ok(updatedEmployee);
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        log.warn("Received request to delete employee with ID: {}", id);
        boolean isDeleted = employeeService.deleteEmployee(id);
        if (isDeleted) {
            log.warn("Employee with ID: {} deleted successfully", id);
            return ResponseEntity.ok("Employee deleted successfully");
        } else {
            log.warn("Employee with ID: {} not found", id);
            return ResponseEntity.status(404).body("Employee not found");
        }
    }


    @GetMapping("/details")
    public List<Employee> getAllEmployees() {
        log.info("Fetching all employees");
        List<Employee> employees = employeeService.getAllEmployees();
        log.info("Total Employees Retrieved: {}", employees.size());
        return employeeService.getAllEmployees();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        log.info("Fetching employee with ID : {}", id);
        Employee employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }


}
