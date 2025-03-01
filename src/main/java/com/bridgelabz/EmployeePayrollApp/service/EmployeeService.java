package com.bridgelabz.EmployeePayrollApp.service;

import com.bridgelabz.EmployeePayrollApp.dto.EmployeeDTO;
import com.bridgelabz.EmployeePayrollApp.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EmployeeService {

    private final List<Employee> employeeList = new ArrayList<>();
    private long idCounter = 1;

    // Create Employee
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(idCounter++, employeeDTO.getName(), employeeDTO.getSalary());
        employeeList.add(employee);
        log.info("ADDED EMPLOYEE");
        return new EmployeeDTO(employee.getName(), employee.getSalary());
    }

    // Get all Employees
    public List<Employee> getAllEmployees() {
        log.info("GET ALL EMPLOYEES");
        return employeeList;
    }

    // Get Employee by ID
    public Employee getEmployeeById(Long id) {
        log.info("GET EMPLOYEE BY ID");
        for (Employee emp : employeeList) {
            if (emp.getId().equals(id)) {
                return emp;
            }
        }
        return null;
    }

    // Update Employee by ID
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        for (Employee emp : employeeList) {
            if (emp.getId().equals(id)) {
                emp.setName(employeeDTO.getName());
                emp.setSalary(employeeDTO.getSalary());
                log.info("UPDATED EMPLOYEE");
                return new EmployeeDTO(emp.getName(), emp.getSalary());
            }
        }
        log.warn("EMPLOYEE NOT EXISTING");
        return null;
    }

    // Delete Employee by ID
    public boolean deleteEmployee(Long id) {
        for (Employee emp : employeeList) {
            if (emp.getId().equals(id)) {
                employeeList.remove(emp);
                log.info("DELETED EMPLOYEE");
                return true;
            }
        }
        return false;
    }
}