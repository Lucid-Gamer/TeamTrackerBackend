package com.apptrove.TeamTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apptrove.TeamTracker.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
