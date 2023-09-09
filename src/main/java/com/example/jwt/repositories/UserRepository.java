package com.example.jwt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jwt.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{
	public Users findByEmail(String email);

}
