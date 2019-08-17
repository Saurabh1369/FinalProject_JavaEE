package com.app.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="package_info")
public class PackageInfo {
	private Integer id;
    private Integer order_id;
    private String description;
    private String item_count;
    private String length;
    private String width; 
    private String height;
    private String weight;
    private String d_type;
    private Integer user_id;
    
    private SourceAddress s;
    
    @JsonIgnore
    @OneToOne
    public SourceAddress getS() {
		return s;
	}
    
    public void addSource( SourceAddress s ){
    	this.s = s;
    	s.setPkg(this);
    }


	public void setS(SourceAddress s) {
		this.s = s;
	}

	public PackageInfo() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Transient
	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getItem_count() {
		return item_count;
	}

	public void setItem_count(String item_count) {
		this.item_count = item_count;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getD_type() {
		return d_type;
	}

	public void setD_type(String d_type) {
		this.d_type = d_type;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "PackageInfo [order_id=" + order_id + ", description=" + description + ", item_count=" + item_count
				+ ", length=" + length + ", width=" + width + ", height=" + height + ", weight=" + weight + ", d_type="
				+ d_type + ", user_id=" + user_id + "]";
	}
    
    
}
