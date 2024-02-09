package com.agsft.service;

import com.agsft.Attendance;

import java.util.List;

public interface EmployeeAttendService {
    Attendance createAttendance(Attendance attendance, Long empId, String designation) ;
    Long getAttendanceCount(Long empId);

    List<Attendance> getAllAttendance();

}
