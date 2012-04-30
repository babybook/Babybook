package com.oak.babybook.db.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.oak.babybook.db.PersonDao;
import com.oak.babybook.objects.Person;

public class PersonDaoImpl implements PersonDao {

	private SessionFactory sessionFactory;

	public PersonDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void insertPerson(Person person){
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(person);
		session.getTransaction().commit();
		session.flush();
		session = null;
	}

	@Override
	public Person getPerson(Long id) {
		Session session = sessionFactory.openSession();
		Person person = (Person)session.load(Person.class, id);
		session.flush();
		session = null;
		return person;
	}

	@Override
	public List<Person> getPersons(List<Long> ids) {
		Session session = sessionFactory.openSession();
		List<Person> persons = new ArrayList<Person>();

		for (Long id : ids){
			Person person = (Person)session.load(Person.class, id);
			persons.add(person);
		}
		session.flush();
		session = null;
		return persons;
	}
	@Override
	public void update(Person person) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.saveOrUpdate(person);
		session.getTransaction().commit();
		session.flush();
		session = null;

	}

	@Override
	public void delete(Person person) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.delete(person);
		session.getTransaction().commit();
		session.flush();
		session = null;
	}

}
