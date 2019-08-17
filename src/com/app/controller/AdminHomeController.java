package com.app.controller;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IAdminHomeDao;
import com.app.pojo.DeliveryType;
import com.app.pojo.SourceAddress;
import com.app.pojo.Users;
import com.app.pojo.Weight;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class AdminHomeController {

	@Autowired
	private IAdminHomeDao dao;

	@GetMapping("/getAllOrders")
	public List<SourceAddress> getAllOrders() {
		System.out.println("AdminHomeController :: getAllOrders() \n\n");
		return dao.getAllOrders();
	}
	
	@DeleteMapping("/deleteOrderById/{id}")
	public void onDelete(@PathVariable int id) {
		System.out.println(id);
		
		dao.onDelete(id);
	}
	
	@GetMapping("/getAllUsers")
	public List<Users> GetAllUsers() {
		return dao.GetAllUsers();
	}
	
	@DeleteMapping("/deleteUserById/{id}")
	public ResponseEntity<String> onDeleteUser(@PathVariable int id) 
	{
		try {
			dao.onDeleteUser(id);
			return new ResponseEntity<>("Success",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Error :"+e.getMessage() ,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getAllWeights")
	public List<Weight> getAllWeights() {
		return dao.getAllWeights();
	}
	
	@GetMapping("/getAlldtype")
	public List<DeliveryType> getAlldtype() {
		return dao.getAlldtype();
	}
	
	@PutMapping("/updateWeight")
	public ResponseEntity<String> updateWeight(@RequestBody Weight w) {
		try {
			dao.updateWeight(w);
			return new ResponseEntity<>("Success",HttpStatus.OK); 
		} catch (Exception e) {
			return new ResponseEntity<>("Error :"+e.getMessage() ,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/updateDtype")
	public ResponseEntity<String> updateDtype(@RequestBody DeliveryType d) {
		try {
			dao.updateDtype(d);
			return new ResponseEntity<>("Success",HttpStatus.OK); 
		} catch (Exception e) {
			return new ResponseEntity<>("Error :"+e.getMessage() ,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("updateOrder")
	public ResponseEntity<String> updateOrder(@RequestBody SourceAddress s) {
		try {
			dao.updateOrder(s);
			return new ResponseEntity<>("Success",HttpStatus.OK); 
		} catch (Exception e) {
			return new ResponseEntity<>("Error :"+e.getMessage() ,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
