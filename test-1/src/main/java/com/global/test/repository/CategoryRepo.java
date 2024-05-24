package com.global.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.global.test.entity.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
