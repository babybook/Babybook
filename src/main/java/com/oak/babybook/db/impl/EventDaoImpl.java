package com.oak.babybook.db.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.oak.babybook.db.EventDao;
import com.oak.babybook.objects.Event;

public class EventDaoImpl implements EventDao {

	private SessionFactory sessionFactory;

	public EventDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void insertEvent(Event event){
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(event);
		session.getTransaction().commit();
		session.flush();
		session = null;
	}

	@Override
	public Event getEvent(Long id) {
		Session session = sessionFactory.openSession();
		Event person = (Event)session.load(Event.class, id);
		return person;
	}

	@Override
	public List<Event> getEvents(List<Long> ids) {
		Session session = sessionFactory.openSession();
		List<Event> events = new ArrayList<Event>();

		for (Long id : ids){
			Event event = (Event)session.load(Event.class, id);
			events.add(event);
		}
		return events;
	}

	@Override
	public void update(Event event) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.saveOrUpdate(event);
		session.getTransaction().commit();
		session.flush();
		session = null;
	}

	@Override
	public void delete(Event event) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.delete(event);
		session.getTransaction().commit();
		session.flush();
		session = null;
	}

}
