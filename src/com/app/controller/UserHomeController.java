package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IUserHomeDao;
import com.app.pojo.SourceAddress;

@RestController
@CrossOrigin(origins = "https://cms-test-project1369.herokuapp.com",allowedHeaders="*")
public class UserHomeController {
	
	@Autowired
	private IUserHomeDao dao;
	
	@GetMapping("/getAllOrders/{id}")
	public List<SourceAddress> getAllOrders(@PathVariable int id ) {
		System.out.println("UserHomeController :: getAllOrders() \n\n");
		return dao.getAllOrders(id);
	}
	
	@GetMapping("/getOrderByID/{id}")
	public SourceAddress getOrderById(@PathVariable int id ) {
		System.out.println("UserHomeController :: getOrderById() \n\n");
		return dao.getOrderById(id);
	}
	
	
}
