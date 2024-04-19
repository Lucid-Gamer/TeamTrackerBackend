package com.apptrove.TeamTracker.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apptrove.TeamTracker.entities.Department;
import com.apptrove.TeamTracker.payload.ApiResponse;
import com.apptrove.TeamTracker.payload.DepartmentDTO;
import com.apptrove.TeamTracker.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public ApiResponse getAllDepartments() {
		Map<String, Object> respObj = new HashMap<>();
		List<Department> deptList = null;
		List<DepartmentDTO> deptListDTO = null;
		try {
			deptList = this.repository.findAll();
			if (deptList != null) {
				deptListDTO = deptList.stream()
						.map(dept -> this.modelMapper.map(dept, DepartmentDTO.class))
						.collect(Collectors.toList());
				respObj.put("respObj", deptListDTO);
				return new ApiResponse(respObj, "Success", true);
			}
			return new ApiResponse("The list of departments is empty", false);
		} catch (Exception e) {
			return new ApiResponse(e.getMessage(), false);
		}
	}

}
