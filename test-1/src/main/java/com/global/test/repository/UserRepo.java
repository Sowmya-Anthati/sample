package com.global.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.global.test.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	
	public User findByEmail(String email);
}
