package com.agsft.controller;

import com.agsft.entity.Employee;
import com.agsft.exceptions.EmployeeNotFoundException;
import com.agsft.service.EmployeeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeDataController {
    @Autowired
    EmployeeDataService employeeDataService;

    @PostMapping("/register/newEmployee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        Employee registered = employeeDataService.registerEmployee(employee);
        return new ResponseEntity<>(registered, HttpStatus.CREATED);
    }

    @GetMapping("/getEmployeeById/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long empId) throws EmployeeNotFoundException {
        Employee employee = employeeDataService.getEmployeeByEmpId(empId);
        return new ResponseEntity<>(employee, HttpStatus.OK);

    }

    @GetMapping("/getEmployeeList")
    public ResponseEntity<List<Employee>> getEmployeeList(){
        List<Employee> allEmployee = employeeDataService.getAllEmployee();
        return new ResponseEntity<>(allEmployee, HttpStatus.OK);
    }

    @PatchMapping("/updateEmployee/{id}/{salary}")
    public ResponseEntity<String> updateEmployeeSalary(@PathVariable(value = "id") Long empId,@PathVariable(value = "salary") Float updateSalary) throws EmployeeNotFoundException {
        String res = employeeDataService.updateEmployeeSalaryByEmpId(empId, updateSalary);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PatchMapping("/updateEmployee/{id}")
    public ResponseEntity<String> updateEmployeeAttendance(@PathVariable(value = "id") Long empId, @RequestParam Float updatedAttendance) throws EmployeeNotFoundException {
        String res = employeeDataService.updateEmployeeAttendanceByEmpId(empId, updatedAttendance);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") Long empId) throws EmployeeNotFoundException {
        String res = employeeDataService.deleteEmployeeByEmpId(empId);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
