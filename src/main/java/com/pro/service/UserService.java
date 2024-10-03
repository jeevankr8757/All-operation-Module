package com.pro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.pro.model.UserDemo;
import com.pro.repository.UserRepository;

@Configuration
public class UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Creating a user
    public UserDemo saveUser(UserDemo user) {
        String hashPwd = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashPwd);
        UserDemo createdUser = userRepo.save(user);
        System.out.println("User data saved : " + createdUser);
        return createdUser;
    }

    // Find user by email
    public UserDemo findUserByEmail(String email) {
        Optional<UserDemo> userOpt = userRepo.findByEmail(email);
        if (userOpt.isPresent()) {
            return userOpt.get();  // Return the user if present
        } else {
            System.out.println("No user found with email: " + email);
            return null;  // Return null or throw an exception if needed
        }
    }

    // Get user by ID
    public Optional<UserDemo> getUserById(long id) {
        return userRepo.findById(id);
    }

    //Getting the all users
	public List<UserDemo> getAllUserList() {
		List<UserDemo> listUser = userRepo.findAll();
		System.out.println("This is the list of users : " + listUser);
		return listUser;
	}

	// Updating the user
	public UserDemo updateUser(UserDemo user, long id) {
		
		return null;
	}
	
	// Update the Employee
		public UserDemo updateEmployee(UserDemo user, long id) {
			user.setUserId(id);
			userRepo.save(user);
//			if(emp.getId() == id) {
//				emp.setEmailId(emp.getEmailId());
//				emp.setFirstName(emp.getFirstName());
//				emp.setLastName(emp.getLastName());
//			}
			System.out.println("Your Employee with id : " + id + "  is updated successfully.. with user data is : " + user);
			return user;

		}

		public void userUpdate(UserDemo user, long userId) {
			user.setUserId(userId);
			userRepo.save(user);
		}
	
}
