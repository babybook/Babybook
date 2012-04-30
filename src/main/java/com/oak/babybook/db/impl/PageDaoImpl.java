package com.oak.babybook.db.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.oak.babybook.db.PageDao;
import com.oak.babybook.objects.Page;

public class PageDaoImpl implements PageDao {

	private SessionFactory sessionFactory;

	public PageDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void insertPage(Page page){
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(page);
		session.getTransaction().commit();
		session.flush();
		session = null;
	}

	@Override
	public Page getPage(Long id) {
		Session session = sessionFactory.openSession();
		Page person = (Page)session.load(Page.class, id);
		return person;
	}

	@Override
	public List<Page> getPages(List<Long> ids) {
		Session session = sessionFactory.openSession();
		List<Page> events = new ArrayList<Page>();

		for (Long id : ids){
			Page event = (Page)session.load(Page.class, id);
			events.add(event);
		}
		return events;
	}

	@Override
	public void update(Page page) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.saveOrUpdate(page);
		session.getTransaction().commit();
		session.flush();
		session = null;
	}

	@Override
	public void delete(Page page) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.delete(page);
		session.getTransaction().commit();
		session.flush();
		session = null;
	}

}
