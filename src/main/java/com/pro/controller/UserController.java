package com.pro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pro.model.UserDemo;
import com.pro.service.UserService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // Simple test to confirm the API is working
    @GetMapping("/test")
    public String test() {
        return "Your Spring Boot demo application API is running successfully.";
    }

    // Create a new user
    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody UserDemo user) {
        userService.saveUser(user);
        return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
    }

    // Get a user by email
    @GetMapping("/getUser/{email}")
    public ResponseEntity<UserDemo> getUserByEmail(@PathVariable String email) {
        System.out.println("Fetching user with email: " + email);
        UserDemo user = userService.findUserByEmail(email);

        // Log the result and return appropriate response
        if (user != null) {
            System.out.println("User found: " + user);
            return ResponseEntity.ok(user);
        } else {
            System.out.println("No user found with email: " + email);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Get a user by ID
    @GetMapping("/user/{id}")
    public ResponseEntity<UserDemo> getUserById(@PathVariable long id) {
        Optional<UserDemo> user = userService.getUserById(id);
        
        // Return 404 if user not found
        return user.isPresent() ? ResponseEntity.ok(user.get()) 
                                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    
    //Get all users
    @GetMapping("/users")
    public List<UserDemo> getAllUsers(){
    	return userService.getAllUserList();
    }
    
    @PutMapping("updateuser/{userId}")
	public ResponseEntity<UserDemo> updateBook(@RequestBody UserDemo user , @PathVariable("userId") long userId) {
		try {
			this.userService.userUpdate(user , userId);
			return ResponseEntity.ok().body(user);
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
