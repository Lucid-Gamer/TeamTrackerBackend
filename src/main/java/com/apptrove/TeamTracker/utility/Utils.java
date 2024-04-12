package com.apptrove.TeamTracker.utility;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.apptrove.TeamTracker.entities.User;

@Component
public class Utils {

	public Map<String,Object> userMapper(User user) {
		Map<String,Object> objMap = new HashMap<>();
		
		try {
			objMap.put("user_id", user.getUserId());
			objMap.put("username", user.getUsername());
			objMap.put("password", user.getPassword());
			objMap.put("lastLogin", user.getLastLoginDate());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return objMap;
	}
	
}
