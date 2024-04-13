package com.apptrove.TeamTracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apptrove.TeamTracker.entities.User;
import com.apptrove.TeamTracker.payload.ApiResponse;
import com.apptrove.TeamTracker.services.UserService;

@RestController
@RequestMapping("/user")
public class LoginController {
	
	@Autowired
	private UserService service;
	
	@PostMapping(path = "/loginUser")
	public ResponseEntity<ApiResponse> loginUser(@RequestBody User userObj) {
		ApiResponse apiResponse = null;
//		JSONObject respObject = new JSONObject();
		try {
			String username = userObj.getUsername();
			String password = userObj.getPassword();
			apiResponse = service.findByUsername(username, password);
			
//			respObject.put("user", user);
		} catch (Exception e) {
			apiResponse = new ApiResponse(e.getMessage(),false);
			return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.FORBIDDEN);
		}
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.ACCEPTED);
	}

}
