package com.apptrove.TeamTracker.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apptrove.TeamTracker.entities.Department;
import com.apptrove.TeamTracker.entities.Employee;
import com.apptrove.TeamTracker.exceptions.ResourceNotFoundException;
import com.apptrove.TeamTracker.payload.ApiResponse;
import com.apptrove.TeamTracker.payload.EmployeeDTO;
import com.apptrove.TeamTracker.repository.DepartmentRepository;
import com.apptrove.TeamTracker.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ApiResponse getAllEmployees() {
		List<Employee> empList = null;
		List<EmployeeDTO> empListDTO = null;
		ApiResponse apiResponse = null;
		Map<String, Object> respObj = new HashMap<String, Object>();
		try {
			empList = repository.findAll();
			if (empList != null && !empList.isEmpty()) {
				empListDTO = empList.stream()
						.map(emp -> this.modelMapper.map(emp, EmployeeDTO.class))
						.collect(Collectors.toList());
				respObj.put("respObj", empListDTO);
				apiResponse = new ApiResponse(respObj, "Success", true);
				return apiResponse;
			} else {
				apiResponse = new ApiResponse("No Data found in Database", false);
			}

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
			employee = this.repository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Employee", "findbyId()", "Employee Id"));
			employeeDTO = this.modelMapper.map(employee, EmployeeDTO.class);
			respObj.put("respObj", employeeDTO);
			apiResponse = new ApiResponse(respObj, "Success", true);
		} catch (Exception e) {
			return new ApiResponse(e.getMessage(), false);
		}
		return apiResponse;
	}

	@Override
	public ApiResponse addEmployee(EmployeeDTO newEmployeeDTO) {
		Map<String, Object> respObj = new HashMap<>();
		ApiResponse apiResponse = null;
		Employee emp = null;
		try {
			int departmentId = newEmployeeDTO.getDepartment_id();
			Department dept = this.departmentRepository.findById(departmentId)
					.orElseThrow(() -> new ResourceNotFoundException("Department", "findById()", "Department Id"));
			emp = this.modelMapper.map(newEmployeeDTO, Employee.class);
			emp.setDepartment(dept);
			emp = this.repository.save(emp);
			respObj.put("respObj", this.modelMapper.map(emp, EmployeeDTO.class));
			apiResponse = new ApiResponse(respObj, "Success", true);
		} catch (Exception e) {
			return new ApiResponse(e.getMessage(), false);
		}
		return apiResponse;
	}

	@Override
	public ApiResponse updateEmployee(EmployeeDTO updatedEmployeeDTO) {
		ApiResponse apiResponse = null;
		Map<String, Object> respObj = new HashMap<>();
		Employee updatedEmp = null;
		Department dept = null;
		try {
			int departmentId = updatedEmployeeDTO.getDepartment_id();
			dept = this.departmentRepository.findById(departmentId)
					.orElseThrow(() -> new ResourceNotFoundException("Department", "findById()", "Department Id"));
			updatedEmp = this.modelMapper.map(updatedEmployeeDTO, Employee.class);
			updatedEmp.setDepartment(dept);
			updatedEmp = this.repository.save(updatedEmp);
			respObj.put("respObj", updatedEmp);
			apiResponse = new ApiResponse(respObj, "Success", true);
		} catch (Exception e) {
			return new ApiResponse(e.getMessage(), false);
		}
		return apiResponse;
	}

}
