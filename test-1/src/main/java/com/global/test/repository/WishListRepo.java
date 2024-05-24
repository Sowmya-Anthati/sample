package com.global.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.global.test.entity.WishList;

@Repository
public interface WishListRepo extends JpaRepository<WishList, Integer>{

}
