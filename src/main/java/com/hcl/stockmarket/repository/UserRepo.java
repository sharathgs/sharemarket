package com.hcl.stockmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.stockmarket.controller.UserController;
import com.hcl.stockmarket.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

}
