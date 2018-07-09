package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByEmailOrUserId(String email, String userId);
	
	User findByUserId(String userId);
	
}
