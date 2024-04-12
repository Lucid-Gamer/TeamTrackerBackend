package com.apptrove.TeamTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apptrove.TeamTracker.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByUsername(String username);
	
}
