package com.oak.babybook.db;

import java.util.List;

import com.oak.babybook.objects.Event;
import com.oak.babybook.objects.Person;

public interface PersonDao {

	public void insertPerson(Person person);
	
	public Person getPerson(Long id);
	
	public List<Person> getPersons(List<Long> ids);
	
	public void update(Person person);
	
	public void delete(Person person);
}