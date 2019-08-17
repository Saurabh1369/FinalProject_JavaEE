package com.app.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="delivery_type")
public class DeliveryType 
{
    private Integer d_type_id;
    private String d_type;
    private float price;
    
    public DeliveryType() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getD_type_id() {
		return d_type_id;
	}

	public void setD_type_id(Integer d_type_id) {
		this.d_type_id = d_type_id;
	}

	public String getD_type() {
		return d_type;
	}

	public void setD_type(String d_type) {
		this.d_type = d_type;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
    
    
}
