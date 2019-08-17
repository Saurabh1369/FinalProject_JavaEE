package com.app.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="source_address")
public class SourceAddress 
{
    private Integer order_id;
    private String fname;
    private String lname;
    private String address;
    private String state;
    private String city;
    private String pincode;
    private String phone;
    private String email;
    private String order_status;
    
	//transient
    private Integer user_id;
    
    private Users u;
    private DestinationAddress d;
    private PackageInfo pkg;
    
    @OneToOne(mappedBy = "s", cascade = CascadeType.ALL )
	public PackageInfo getPkg() {
		return pkg;
	}

	public void setPkg(PackageInfo pkg) {
		this.pkg = pkg;
	}

	@OneToOne(mappedBy = "s", cascade = CascadeType.ALL )
    public DestinationAddress getD() {
		return d;
	}
    
    public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public void setD(DestinationAddress d) {
		this.d = d;
	}

	public void addUser (Users  u){
    	this.u = u;
    	u.getSaddr().add(this);
    }
    

    @ManyToOne
    public Users getU() {
		return u;
	}

	public void setU(Users u) {
		this.u = u;
	}

	public SourceAddress() {	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
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

	@Override
	public String toString() {
		return "SourceAddress [order_id=" + order_id + ", fname=" + fname + ", lname=" + lname + ", address=" + address
				+ ", state=" + state + ", city=" + city + ", pincode=" + pincode + ", phone=" + phone + ", email="
				+ email + ", order_status=" + order_status + ", user_id=" + user_id + ", u=" + u + ", d=" + d + "]";
	}


    
}
