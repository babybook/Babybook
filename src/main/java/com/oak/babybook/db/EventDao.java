package com.oak.babybook.db;

import java.util.List;

import com.oak.babybook.objects.Event;

public interface EventDao {

	public void insertEvent(Event event);
	
	public Event getEvent(Long id);
	
	public List<Event> getEvents(List<Long> ids);
	
	public void update(Event event);
	
	public void delete(Event event);
}