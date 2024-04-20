package com.apptrove.TeamTracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apptrove.TeamTracker.payload.ApiResponse;
import com.apptrove.TeamTracker.services.EmployeeService;

@RestController
@CrossOrigin
@RequestMapping(path = "/emp")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/getAll")
	public ResponseEntity<ApiResponse> getAllEmployees() {
		ApiResponse apiResponse = null;
		try {
			apiResponse = this.service.getAllEmployees();
		} catch (Exception e) {
			apiResponse = new ApiResponse(e.getMessage(), false);
			return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<ApiResponse>(apiResponse,apiResponse.getFlag() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

}
