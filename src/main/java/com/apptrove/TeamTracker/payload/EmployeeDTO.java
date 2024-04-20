package com.apptrove.TeamTracker.payload;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeDTO {

	private int emp_id;
	private String emp_fname;
	private String emp_lname;
	private Date emp_dob;
	private Date emp_doj;
	private String emp_bldGrp;
	private String designation;
	private int department_id;
	private DepartmentDTO department;

	
}
