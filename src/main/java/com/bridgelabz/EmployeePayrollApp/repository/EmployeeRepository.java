package com.bridgelabz.EmployeePayrollApp.repository;
import com.bridgelabz.EmployeePayrollApp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT e FROM Employee e WHERE :department MEMBER OF e.department")
    List<Employee> findEmployeesByDepartment(@Param("department") String department);
}
