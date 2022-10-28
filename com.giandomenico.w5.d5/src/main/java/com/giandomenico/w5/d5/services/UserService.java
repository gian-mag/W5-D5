package com.giandomenico.w5.d5.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.giandomenico.w5.d5.entities.User;
import com.giandomenico.w5.d5.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository ur;
	
	public List<User> getAll() {
		return ur.findAll();
	}
	
	public void addUser(User u) {
		ur.save(u);
	}
	
	public User findUserById(Long id){
        return ur.findById(id).isPresent() ? ur.findById(id).get() : null;
    }
	
}
