package com.app.dao;

import java.util.List;

import org.apache.catalina.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojo.DeliveryType;
import com.app.pojo.SourceAddress;
import com.app.pojo.Users;
import com.app.pojo.Weight;

@Repository
@Transactional
public class AdminHomeDao implements IAdminHomeDao {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public List<SourceAddress> getAllOrders() {
		String jpql = "select s from SourceAddress s";
		return sf.getCurrentSession().createQuery(jpql, SourceAddress.class).getResultList();
	}

	@Override
	public void onDelete(int id) {
		SourceAddress s = sf.getCurrentSession().load(SourceAddress.class, id);
		if (s != null)
			sf.getCurrentSession().delete( s );
	}

	@Override
	public List<Users> GetAllUsers() {
		String jpql = "select u from Users u";
		return sf.getCurrentSession().createQuery(jpql, Users.class).getResultList();
	}

	@Override
	public void onDeleteUser(int id) {
		sf.getCurrentSession().delete(sf.getCurrentSession().load(Users.class, id));
	}

	@Override
	public List<Weight> getAllWeights() {
		String jpql = "select w from Weight w";
		return sf.getCurrentSession().createQuery(jpql,Weight.class).getResultList();
	}

	@Override
	public List<DeliveryType> getAlldtype() {
		String jpql = "select d from DeliveryType d";
		return sf.getCurrentSession().createQuery(jpql,DeliveryType.class).getResultList();
	}

	@Override
	public void updateWeight(Weight w) {
		sf.getCurrentSession().saveOrUpdate(w);
	}

	@Override
	public void updateDtype(DeliveryType d) {
		sf.getCurrentSession().saveOrUpdate(d);
	}

	@Override
	public void signupService(User u) {
		sf.getCurrentSession().persist(u);
	}

	@Override
	public void updateOrder(SourceAddress s) {
		sf.getCurrentSession().get(SourceAddress.class, s.getOrder_id()).setOrder_status(s.getOrder_status());
	}
}
