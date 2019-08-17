package com.app.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="destination_address")
public class DestinationAddress {
	
	private Integer did;

	private String fname;
    private String lname;
    private String address;
    private String state;
    private String city;
    private String pincode;
    private String phone;
    private String email;
    
    //transient
    private Integer user_id;
    private Integer order_id;
    
    private Users u;
    private SourceAddress s;
    
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getDid() {
		return did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}
    
    public DestinationAddress() {	}
    
    //check this
    public void addSource( SourceAddress s ){
    	this.s = s;
    	s.setD(this);
    }

    public void addUser (Users  u){
    	this.u = u;
    	u.getDaddr().add(this);
    }
    
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Transient
	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	@Transient
	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	@ManyToOne
	public Users getU() {
		return u;
	}

	public void setU(Users u) {
		this.u = u;
	}

	@JsonIgnore
	@OneToOne
	public SourceAddress getS() {
		return s;
	}

	public void setS(SourceAddress s) {
		this.s = s;
	}
    
    
    
}
