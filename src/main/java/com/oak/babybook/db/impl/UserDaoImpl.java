package com.oak.babybook.db.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.oak.babybook.db.UserDao;
import com.oak.babybook.objects.User;

public class UserDaoImpl implements UserDao {

	Logger log = Logger.getLogger(this.getClass());
	
	private SessionFactory sessionFactory;

	public UserDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void insertUser(User user){
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(user);
		session.getTransaction().commit();
		session.flush();
		session = null;
	}
	
	@Override
	public User getUser(Long id) {
		Session session = sessionFactory.openSession();
		User user  = (User)session.load(User.class, id);
		session = null;
		return user;
	}

	@Override
	public List<User> getUsers(List<Long> ids) {
		Session session = sessionFactory.openSession();
		List<User> users = new ArrayList<User>();
		
		for (Long id : ids){
			User user = (User)session.load(User.class, id);
			users.add(user);
		}
		session = null;
		
		return users;
	}
	
	@Override
	public void updateUser(User user){
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.merge(user);
		session.getTransaction().commit();
		session.flush();
		session = null;
	}

	@SuppressWarnings("unchecked")
	public User getUserByNamePass(String userName, String password) throws Exception {
		Session session = sessionFactory.openSession();
		
		List users  = session.createCriteria(User.class)
					.add( Restrictions.eq("username", userName))
					.add( Restrictions.eq("password", password))
					.list();
	
		if (users.size() > 1){
			throw new Exception("More than one user with the username : " + userName + " and password : " + password);
		}
		
		if (users.size() == 1){
			User user = (User)users.get(0);
			log.info("Found one User with ID : "+ user.getId());
			
			return getUser(user.getId());
		}else{
			session = null;
			throw new Exception("No user found with the username : " + userName + " and password : " + password);
		}
	}
	
	@Override
	public void delete(User user) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.delete(user);
		session.getTransaction().commit();
		session = null;
	}

}
