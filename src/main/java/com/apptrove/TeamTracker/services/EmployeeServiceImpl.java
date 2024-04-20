package com.apptrove.TeamTracker.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apptrove.TeamTracker.entities.Employee;
import com.apptrove.TeamTracker.payload.ApiResponse;
import com.apptrove.TeamTracker.payload.EmployeeDTO;
import com.apptrove.TeamTracker.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public ApiResponse getAllEmployees() {
		List<Employee> empList = null;
		List<EmployeeDTO> empListDTO = null;
		ApiResponse apiResponse = null;
		Map<String, Object> respObj = new HashMap<String,Object>();
		try {
			empList = repository.findAll();
			if (empList != null) {
				empListDTO = empList.stream()
						.map(emp -> this.modelMapper.map(emp, EmployeeDTO.class))
						.collect(Collectors.toList());
				respObj.put("respObj", empListDTO);
				apiResponse = new ApiResponse(respObj, "Success", true);
				return apiResponse;
			}
			apiResponse = new ApiResponse("Data not found", false);
		} catch (Exception e) {
			return new ApiResponse(e.getMessage(), false);
		}
		return apiResponse;
	}

	@Override
	public ApiResponse findEmployeeById(Integer id) {
		ApiResponse apiResponse = null;
		Map<String, Object> respObj = new HashMap<>();
		Employee employee = null;
		EmployeeDTO employeeDTO = null;
		try {
			
		} catch (Exception e) {
			return new ApiResponse(e.getMessage(), false);
		}
		return null;
	}

	@Override
	public ApiResponse addEmployee(EmployeeDTO newEmployeeDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResponse updateEmployee(EmployeeDTO updatedEmployeeDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
