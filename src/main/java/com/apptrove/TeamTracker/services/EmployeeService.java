package com.apptrove.TeamTracker.services;

import com.apptrove.TeamTracker.payload.ApiResponse;
import com.apptrove.TeamTracker.payload.EmployeeDTO;

public interface EmployeeService {

	public ApiResponse getAllEmployees();
	
	public ApiResponse findEmployeeById(Integer id);
	
	public ApiResponse addEmployee(EmployeeDTO newEmployeeDTO);
	
	public ApiResponse updateEmployee(EmployeeDTO updatedEmployeeDTO);
	
}
