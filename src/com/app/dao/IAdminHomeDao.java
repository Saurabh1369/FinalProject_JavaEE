package com.app.dao;

import java.util.List;

import org.apache.catalina.User;

import com.app.pojo.DeliveryType;
import com.app.pojo.SourceAddress;
import com.app.pojo.Users;
import com.app.pojo.Weight;

public interface IAdminHomeDao {

	public void onDelete(int id);

	public List<SourceAddress> getAllOrders();

	public List<Users> GetAllUsers();

	public void onDeleteUser(int id);

	public List<Weight> getAllWeights();

	public List<DeliveryType> getAlldtype();

	public void updateWeight(Weight w);

	public void updateDtype(DeliveryType d);

	public void signupService(User u);

	public void updateOrder(SourceAddress s);

}
