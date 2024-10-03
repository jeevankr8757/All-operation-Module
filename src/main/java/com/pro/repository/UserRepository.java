package com.pro.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pro.model.UserDemo;

public interface UserRepository extends JpaRepository<UserDemo, Long> {
	Optional<UserDemo> findByEmail(String email);
}
