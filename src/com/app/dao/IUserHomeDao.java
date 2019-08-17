package com.app.dao;

import java.util.List;

import com.app.pojo.SourceAddress;

public interface IUserHomeDao {

	public List<SourceAddress> getAllOrders(int id);

	public SourceAddress getOrderById(int id);

}
