package com.apptrove.TeamTracker.payload;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ApiResponse {
	
	private Map<String,Object> respObject;
	
	private String message;
	
	private boolean flag;
	
	public ApiResponse() {}

	public ApiResponse(Map<String, Object> respObject, String message, boolean flag) {
		this.respObject = respObject;
		this.message = message;
		this.flag = flag;
	}

	public ApiResponse(String message, boolean flag) {
		this.message = message;
		this.flag = flag;
	}
	
	public boolean getFlag() {
		return this.flag;
	}

}
