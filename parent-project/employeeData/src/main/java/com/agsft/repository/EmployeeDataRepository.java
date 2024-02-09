package com.agsft.repository;

import com.agsft.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDataRepository extends JpaRepository<Employee, Long> {
}
