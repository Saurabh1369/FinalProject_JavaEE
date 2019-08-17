package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojo.SourceAddress;

@Repository
@Transactional
public class UserHomeDao implements IUserHomeDao{
	
	@Autowired
	private SessionFactory sf;

	@Override
	public List<SourceAddress> getAllOrders(int id) {
		String jpql = "select s from SourceAddress s where s.u.user_id=:id";
		return sf.getCurrentSession().createQuery(jpql, SourceAddress.class).setParameter("id", id).getResultList();
	}

	@Override
	public SourceAddress getOrderById(int id) {
		return sf.getCurrentSession().get(SourceAddress.class, id);
	}

}
