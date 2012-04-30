package com.oak.babybook.services;

import java.util.List;

import com.oak.babybook.objects.Event;
import com.oak.babybook.objects.Person;

public interface PersonService {

	public Person getPerson(Long id);
	
	public void insertPerson(Person person);
	
	public List<Person> getPersons(List<Long> ids);

	public void update(Person person);
	
	public void delete(Person person);
}
