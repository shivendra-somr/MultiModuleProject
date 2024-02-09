package com.agsft.repository;

import com.agsft.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeAttendRepository extends JpaRepository<Attendance,Long> {
}
