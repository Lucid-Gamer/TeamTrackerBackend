package com.apptrove.TeamTracker.services;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apptrove.TeamTracker.entities.User;
import com.apptrove.TeamTracker.payload.ApiResponse;
import com.apptrove.TeamTracker.repository.UserRepository;
import com.apptrove.TeamTracker.utility.Utils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private Utils utils;

	@Override
	public ApiResponse findByUsername(String username, String password) {
		User user = new User();
		String response = null;
		Map<String, Object> respObj = new HashMap<String, Object>();
		ApiResponse apiResponse = null;
		try {
			user = repository.findByUsername(username);
			if (user == null) {
				response = new String(username + " is not part of the administration. Kindly contact admin.");
				return new ApiResponse(response, false);
			}

			if (user.getLastLoginDate() == null) {
				response = new String(username + " is already logged in.");
				respObj = utils.userMapper(user);
				return new ApiResponse(respObj, response, false);
			}

			if (!user.getPassword().equals(password)) {
				response = new String(username + " has entered wrong password. Kindly re-enter the correct password.");
				return new ApiResponse(response, false);
			}

			System.out.println(user);
			respObj = utils.userMapper(user);
			user.setLastLoginDate(null);
			repository.save(user);
			response = "User Login Successful";
			apiResponse = new ApiResponse(respObj, response, true);
		} catch (Exception e) {
			response = new String(e.getMessage());
			return new ApiResponse(response, false);
		}

		return apiResponse;
	}

}
