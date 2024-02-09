package com.agsft.service;

import com.agsft.entity.Employee;
import com.agsft.exceptions.EmployeeNotFoundException;

import java.util.List;

public interface EmployeeDataService {
    Employee registerEmployee(Employee employee);
    Employee getEmployeeByEmpId(Long empId) throws   EmployeeNotFoundException;

    List<Employee> getAllEmployee();

    String updateEmployeeSalaryByEmpId(Long empId, Float updatedSalary) throws   EmployeeNotFoundException;

    String updateEmployeeAttendanceByEmpId(Long empId, Float updatedAttendance) throws EmployeeNotFoundException;

    String deleteEmployeeByEmpId(Long empId) throws EmployeeNotFoundException;

}
