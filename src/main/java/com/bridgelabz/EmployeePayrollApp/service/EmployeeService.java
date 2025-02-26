package com.bridgelabz.EmployeePayrollApp.service;

import com.bridgelabz.EmployeePayrollApp.dto.EmployeeDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    List<EmployeeDTO> employeeList=new ArrayList<>();

    public List<EmployeeDTO> getAllEmployee() {
        return employeeList;
    }
    public String addEmployee(EmployeeDTO employeeDTO){
        employeeList.add(employeeDTO);
        return employeeDTO.toString()+" added successfully!";
    }
    public String deleteEmployeeByName(String name){
        for(EmployeeDTO employee:employeeList){
            if(employee.getName().equalsIgnoreCase(name)) {
                employeeList.remove(employee);
                return "Employee deleted successfully!";
            }
        }
        return "Employee not found!";
    }
    public String updateEmployeeByName(String name,EmployeeDTO updatedEmployee){
        for (EmployeeDTO employee:employeeList){
            if(employee.getName().equalsIgnoreCase(name))
            {
                employee.setName(updatedEmployee.getName());
                employee.setSalary(updatedEmployee.getSalary());
                return "Employee updated successfully! =>"+employee.toString();
            }
        }
        return "Employee not found!";
    }
    public  String getEmployeeByName(String name){
        for(EmployeeDTO employee:employeeList){
            if(employee.getName().equalsIgnoreCase(name)) {
                return employee.toString();
            }
        }
        return "Employee not found!";
    }
}
