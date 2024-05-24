package com.global.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.global.test.entity.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer>{

}
