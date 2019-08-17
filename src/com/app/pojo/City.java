package com.app.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="city")
public class City {
	private Integer city_id;
	private String city_name;
	private String state_id;
	
	public City() {	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getCity_id() {
		return city_id;
	}

	public void setCity_id(Integer city_id) {
		this.city_id = city_id;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	public String getState_id() {
		return state_id;
	}

	public void setState_id(String state_id) {
		this.state_id = state_id;
	}

	@Override
	public String toString() {
		return "City [city_id=" + city_id + ", city_name=" + city_name + ", state_id=" + state_id + "]";
	}
	
	
}
