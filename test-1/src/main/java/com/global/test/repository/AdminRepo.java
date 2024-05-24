package com.global.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.global.test.entity.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer>{
     
	public Admin findByEmail(String email);
}
