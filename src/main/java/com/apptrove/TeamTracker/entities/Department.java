package com.apptrove.TeamTracker.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "departments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "department_id")
	private int department_id;
	
	@Column(name = "department_name")
	private String department_name;
	
	@Column(name = "department_location")
	private String department_location;
	
	@OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
	private List<Employee> employees = new ArrayList<>();
	
}
