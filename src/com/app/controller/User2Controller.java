package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IUserDao;
import com.app.pojo.City;
import com.app.pojo.DeliveryType;
import com.app.pojo.DestinationAddress;
import com.app.pojo.PackageInfo;
import com.app.pojo.SourceAddress;
import com.app.pojo.States;
import com.app.pojo.Weight;

@RestController
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")
public class User2Controller {
	
	@Autowired
	private IUserDao dao;
	
	@GetMapping("/states")
	public List<States> getStates( ) {
		System.out.println("User2Controller :: getStates() \n\n");
		return dao.getStates( );
	}
	
	@PostMapping("/city")
	public List<City> getCity( @RequestBody String selectedState) {
		System.out.println("User2Controller :: getCity() \n\n");
		
		return dao.getCity( selectedState );
	}
	
	@PostMapping("/statebyID")
	public States getStatesbyID(@RequestBody int id ) {
		System.out.println("User2Controller :: getStates() \n\n");
		return dao.getStatesbyID(id  );
	}
	
	@PostMapping("/pickupAddress")
	public ResponseEntity<String> onPickupSubmit( @RequestBody SourceAddress saddr) {
		try {
			System.out.println("User2Controller :: onPickupSubmit() \n\n");

			return new ResponseEntity<String> ( dao.onPickupSubmit( saddr ) ,HttpStatus.OK );			
		} catch (Exception e) {
			return new ResponseEntity<String> ("ERROR :"+e.getMessage() ,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/destination")
	public ResponseEntity<String> onDestineSubmit( @RequestBody DestinationAddress daddr) {
		try {
			System.out.println("User2Controller :: onDestineSubmit() \n\n");

			return new ResponseEntity<String> ( dao.onDestineSubmit( daddr ) ,HttpStatus.OK );			
		} catch (Exception e) {
			return new ResponseEntity<String> ("ERROR :"+e.getMessage() ,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/Weights")
	public List<Weight> getWeights( ) {
		System.out.println(" getWeights() \n\n");
		return dao.getWeights();
	}
	
	@GetMapping("/dtype")
	public List<DeliveryType> getDtype( ) {
		System.out.println(" getDtype() \n\n");
		return dao.getDtype();
	}
	
	@PostMapping("/packageInfo")
	public ResponseEntity<String> onPackageSubmit( @RequestBody PackageInfo pkg) 
	{
		System.out.println(pkg.toString());
		try {
			dao.onPackageSubmit( pkg );
			return new ResponseEntity<String> ( "Success" ,HttpStatus.OK );
		} catch (Exception e) {
			return new ResponseEntity<String> ( "Error :"+e.getMessage() ,HttpStatus.OK );	
		}
	}

}
