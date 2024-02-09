package com.agsft.controller;

import com.agsft.Attendance;
import com.agsft.service.EmployeeAttendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeAttendController {

    @Autowired
    EmployeeAttendService employeeAttendService;

    @PostMapping("/createAttendance/{id}")
    public ResponseEntity<Attendance> registerAttendance(@RequestBody Attendance attendance, @PathVariable("id") Long empId, @RequestParam String designation){
        return new ResponseEntity<>(employeeAttendService.createAttendance(attendance,empId,designation), HttpStatus.CREATED);
    }

    @GetMapping("/employee/attendCount/{id}")
    public ResponseEntity<Long> getAttendanceCountByEmpId(@PathVariable("id") Long empId){
        return new ResponseEntity<>(employeeAttendService.getAttendanceCount(empId),HttpStatus.OK);
    }

    @GetMapping("/employee/attendList")
    public ResponseEntity<List<Attendance>> getAllAttendance(){
        return new ResponseEntity<>(employeeAttendService.getAllAttendance(),HttpStatus.OK);
    }
}
