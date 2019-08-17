package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IUserDao;
import com.app.pojo.Users;

@RestController
@CrossOrigin(origins = "https://cms-test-project1369.herokuapp.com",allowedHeaders="*")
@RequestMapping("/users")
public class UserController 
{
	@Autowired
	private IUserDao dao;
	
	@PostMapping("/signup")
	public void signup( @RequestBody Users u ) {
		System.out.println(dao.signup(u));
	}
	
	
	@PostMapping("/login")
	public Users login(@RequestBody Users u) {
		System.out.println("in UserController :: login()\n\n" );		
		Users u1 = null;
		try {
			
			u1 = dao.login(u);
			System.out.println( u1.toString() );
			
		} catch (Exception e) {
			System.out.println("NOT FOUND");
		}
		return u1;
	}
}
