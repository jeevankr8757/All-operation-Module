package com.pro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDemo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	private String name;
	private String email;
	private String password;
	private String role;
	
}
