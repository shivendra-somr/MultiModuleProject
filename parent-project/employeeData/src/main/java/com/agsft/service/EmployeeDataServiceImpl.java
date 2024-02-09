package com.agsft.service;

import com.agsft.entity.Employee;
import com.agsft.exceptions.EmployeeNotFoundException;
import com.agsft.repository.EmployeeDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeDataServiceImpl implements EmployeeDataService{


    @Autowired
    EmployeeDataRepository employeeDataRepository;

    @Override
    public Employee registerEmployee(Employee employee) {
        return employeeDataRepository.save(employee);
    }

    @Override
    public Employee getEmployeeByEmpId(Long empId) throws EmployeeNotFoundException{
        Optional<Employee> employee = employeeDataRepository.findById(empId);
        if(employee.isPresent()){
            return employee.get();
        }
        else {
            throw new EmployeeNotFoundException("Invalid Employee Id!");
        }

    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeDataRepository.findAll();
    }

    @Override
    public String updateEmployeeSalaryByEmpId(Long empId, Float updatedSalary) throws EmployeeNotFoundException {
        Optional<Employee> employee = employeeDataRepository.findById(empId);
        if(employee.isPresent()){
            Employee emp = employee.get();
            emp.setSalary(updatedSalary);
            employeeDataRepository.save(emp);
            return "Employee Salary Updated Successfully";
        }
        else {
            throw new EmployeeNotFoundException("Invalid Employee Id!");
        }
    }

    @Override
    public String updateEmployeeAttendanceByEmpId(Long empId, Float updatedAttendance) throws EmployeeNotFoundException {
        Optional<Employee> employee = employeeDataRepository.findById(empId);
        if(employee.isPresent()){
            Employee emp = employee.get();
            emp.setAttendance(updatedAttendance);
            employeeDataRepository.save(emp);
            return "Employee Attendance Updated Successfully";
        }
        else {
            throw new EmployeeNotFoundException("Invalid Employee Id!");
        }
    }

    @Override
    public String deleteEmployeeByEmpId(Long empId) throws EmployeeNotFoundException {
        Optional<Employee> employee = employeeDataRepository.findById(empId);
        if(employee.isPresent()){
            employeeDataRepository.delete(employee.get());
            return "Employee Deleted Successfully";
        }
        else{
            throw new EmployeeNotFoundException("Invalid Employee Id!");
        }
    }
}
