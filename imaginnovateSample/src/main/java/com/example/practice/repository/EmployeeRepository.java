package com.example.practice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.practice.entity.EmployeeDto;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDto, Integer>{

	Optional<List<EmployeeDto>> findByIsActive(int isActive);
}
