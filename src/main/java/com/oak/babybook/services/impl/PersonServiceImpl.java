package com.oak.babybook.services.impl;

import java.util.List;

import com.oak.babybook.db.impl.PersonDaoImpl;
import com.oak.babybook.objects.Person;
import com.oak.babybook.objects.Picture;
import com.oak.babybook.services.PersonService;

public class PersonServiceImpl implements PersonService {

	private PersonDaoImpl personDao;

	public PersonServiceImpl(PersonDaoImpl personDao){
		this.personDao = personDao;
	}

	@Override
	public Person getPerson(Long id) {
		return this.personDao.getPerson(id);
	}

	@Override
	public List<Person> getPersons(List<Long> ids) {
		return this.personDao.getPersons(ids);
	}

	@Override
	public void insertPerson(Person person) {
		this.personDao.insertPerson(person);
	}

	@Override
	public void update(Person person) {
		this.personDao.update(person);
	}

	@Override
	public void delete(Person person) {
		this.personDao.delete(person);

	}
}
