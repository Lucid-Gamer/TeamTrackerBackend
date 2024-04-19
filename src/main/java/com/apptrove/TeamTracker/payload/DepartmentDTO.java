package com.apptrove.TeamTracker.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DepartmentDTO {

	private int department_id;
	
	private String department_name;
	
	private String department_location;
}
