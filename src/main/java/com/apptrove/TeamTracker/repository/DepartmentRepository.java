package com.apptrove.TeamTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apptrove.TeamTracker.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
