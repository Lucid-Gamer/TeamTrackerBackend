package com.apptrove.TeamTracker.services;

import com.apptrove.TeamTracker.payload.ApiResponse;

public interface UserService {
	
	public ApiResponse findByUsername(String username,String password);

}
