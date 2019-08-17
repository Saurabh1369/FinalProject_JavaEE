package com.app.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="weight")
public class Weight {
    private Integer weight_id;
    private String weight_range;
    private float price;
    
    public Weight() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getWeight_id() {
		return weight_id;
	}

	public void setWeight_id(Integer weight_id) {
		this.weight_id = weight_id;
	}

	public String getWeight_range() {
		return weight_range;
	}

	public void setWeight_range(String weight_range) {
		this.weight_range = weight_range;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Weight [weight_id=" + weight_id + ", weight_range=" + weight_range + ", price=" + price + "]";
	}
    
    
    
    
}
