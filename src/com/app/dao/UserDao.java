package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojo.City;
import com.app.pojo.DeliveryType;
import com.app.pojo.DestinationAddress;
import com.app.pojo.PackageInfo;
import com.app.pojo.SourceAddress;
import com.app.pojo.States;
import com.app.pojo.Users;
import com.app.pojo.Weight;

@Repository
@Transactional
public class UserDao implements IUserDao
{
	@Autowired
	private SessionFactory sf;
	
	public String signup(Users u)
	{
		sf.getCurrentSession().save(u);
		return "User added successfully with ID " + u.getUser_id();
	}
	
	public Users login(Users u) 
	{
		String jpql = "select u from Users u where email=:em and password=:pass";
		return sf.getCurrentSession().createQuery(jpql,Users.class).setParameter("em", u.getEmail()).setParameter("pass", u.getPassword()).getSingleResult();
	}

	@Override
	public List<States> getStates() {
		String jpql = "select s from States s";
		List <States> l = sf.getCurrentSession().createQuery(jpql,States.class).getResultList();
		return l;
	}

	@Override
	public List<City> getCity(String selectedState) {
		String jpql = "select c from City c where state_id = :id";
		return sf.getCurrentSession().createQuery(jpql,City.class).setParameter("id", selectedState).getResultList();
	}

	@Override
	public States getStatesbyID(int id) {
		return sf.getCurrentSession().get(States.class, id);
	}

	@Override
	public String onPickupSubmit(SourceAddress saddr) {
		
		Users u = sf.getCurrentSession().get(Users.class, saddr.getUser_id());
		sf.getCurrentSession().persist( saddr );
		saddr.addUser(u);
		
		return saddr.getOrder_id().toString();
	}

	@Override
	public String onDestineSubmit(DestinationAddress daddr) {
		
		Users u = sf.getCurrentSession().get( Users.class,daddr.getUser_id() );
		sf.getCurrentSession().persist( daddr );
		daddr.addUser(u);
		
		SourceAddress s = sf.getCurrentSession().get(SourceAddress.class, daddr.getOrder_id());
		daddr.addSource(s);
		
		return daddr.getDid().toString();
	}

	@Override
	public List<Weight> getWeights() {
		String jpql = "select w from Weight w";
		return sf.getCurrentSession().createQuery(jpql, Weight.class).getResultList();
	}

	@Override
	public List<DeliveryType> getDtype() {
		String jpql = "select d from DeliveryType d";
		return sf.getCurrentSession().createQuery(jpql, DeliveryType.class).getResultList();
	}

	@Override
	public String onPackageSubmit(PackageInfo pkg) {
		pkg.addSource(sf.getCurrentSession().get(SourceAddress.class, pkg.getOrder_id()));
		sf.getCurrentSession().persist( pkg );
		return null;
	}
}
