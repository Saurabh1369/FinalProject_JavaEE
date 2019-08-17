package com.app.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="states")
public class States 
{
	private Integer state_id;
	private String state_name;
	
	public States() {	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getState_id() {
		return state_id;
	}

	public void setState_id(Integer state_id) {
		this.state_id = state_id;
	}

	public String getState_name() {
		return state_name;
	}

	public void setState_name(String state_name) {
		this.state_name = state_name;
	}

	@Override
	public String toString() {
		return "States [state_id=" + state_id + ", state_name=" + state_name + "]";
	}




	
	
}
