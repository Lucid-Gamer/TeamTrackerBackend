package com.apptrove.TeamTracker.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employees")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private int emp_id;
	
	@Column(name = "emp_fname")
	private String emp_fname;
	
	@Column(name = "emp_lname")
	private String emp_lname;
	
	@Column(name = "emp_dob")
	private Date emp_dob;
	
	@Column(name = "emp_doj")
	private Date emp_doj;
	
	@Column(name = "emp_bld_grp")
	private String emp_bldGrp;
	
	@Column(name = "designation")
	private String designation;

	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;
}
