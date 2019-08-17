package com.app.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="users")
public class Users 
{
	private Integer user_id;
	private String fname;
	private String lname;
	private String email;
	private String password;
	private String user_type;
	private List<SourceAddress> saddr = new ArrayList<SourceAddress >();
	private List<DestinationAddress> daddr = new ArrayList< DestinationAddress >();
	


	@JsonIgnore
	@OneToMany(mappedBy = "u", cascade = CascadeType.ALL )
	public List<SourceAddress> getSaddr() {
		return saddr;
	}

	public void setSaddr(List<SourceAddress> saddr) {
		this.saddr = saddr;
	}
	
	@JsonIgnore
	@OneToMany(mappedBy = "u", cascade = CascadeType.ALL )
	public List<DestinationAddress> getDaddr() {
		return daddr;
	}

	public void setDaddr(List<DestinationAddress> daddr) {
		this.daddr = daddr;
	}

	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", fname=" + fname + ", lname=" + lname + ", email=" + email
				+ ", password=" + password + ", user_type=" + user_type + "]";
	}

	public Users() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	
	
}
