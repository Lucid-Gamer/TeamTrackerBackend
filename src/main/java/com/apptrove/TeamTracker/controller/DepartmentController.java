package com.apptrove.TeamTracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apptrove.TeamTracker.payload.ApiResponse;
import com.apptrove.TeamTracker.services.DepartmentService;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/dept")
public class DepartmentController {

	@Autowired
	private DepartmentService service;
	
	@GetMapping(path = "/getAll")
	public ResponseEntity<ApiResponse> getAllDepartments() {
		ApiResponse apiResponse = null;
		try {
			apiResponse = this.service.getAllDepartments();
		} catch (Exception e) {
			apiResponse = new ApiResponse(e.getMessage(), false);
			return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<ApiResponse>(apiResponse,apiResponse.getFlag() ? HttpStatus.ACCEPTED : HttpStatus.NO_CONTENT);
	}
	
}
