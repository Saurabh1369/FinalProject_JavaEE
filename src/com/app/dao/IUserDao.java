package com.app.dao;

import java.util.List;

import com.app.pojo.City;
import com.app.pojo.DeliveryType;
import com.app.pojo.DestinationAddress;
import com.app.pojo.PackageInfo;
import com.app.pojo.SourceAddress;
import com.app.pojo.States;
import com.app.pojo.Users;
import com.app.pojo.Weight;

public interface IUserDao {

	public String signup(Users u);
	public Users login(Users u);
	public List<States> getStates();
	public List<City> getCity(String selectedState);
	public States getStatesbyID(int id);
	public String onPickupSubmit(SourceAddress saddr);
	public String onDestineSubmit(DestinationAddress daddr);
	public List<Weight> getWeights();
	public List<DeliveryType> getDtype();
	public String onPackageSubmit(PackageInfo pkg);
}
