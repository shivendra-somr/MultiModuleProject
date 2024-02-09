package com.agsft.service;

import com.agsft.Attendance;
import com.agsft.repository.EmployeeAttendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class EmployeeAttendServiceImpl implements EmployeeAttendService{
    @Autowired
    EmployeeAttendRepository employeeAttendRepository;

    @Override
    public Attendance createAttendance(Attendance attendance, Long empId, String designation) {
        Attendance at = new Attendance();

        at.setEmployeeId(String.valueOf(empId));
        at.setDesignation(designation);
        at.setCheckIn(attendance.getCheckIn());
        at.setCheckOut(attendance.getCheckOut());
        at.setAvailable(attendance.getAvailable());

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        at.setDate(LocalDateTime.now().format(dtf));

        at.setMonth(LocalDateTime.now().getMonth().toString());
        at.setAttendCount(1);

        return employeeAttendRepository.save(at);
    }

    @Override
    public Long getAttendanceCount(Long empId) {
        return employeeAttendRepository.findById(empId).get().getAttendCount();
    }

    @Override
    public List<Attendance> getAllAttendance() {
        return employeeAttendRepository.findAll();
    }
}
