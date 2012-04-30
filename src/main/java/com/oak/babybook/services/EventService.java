package com.oak.babybook.services;

import java.util.List;

import com.oak.babybook.objects.Event;

public interface EventService {

	public Event getEvent(Long id);
	
	public void insertEvent(Event event);
	
	public List<Event> getEvents(List<Long> ids);
	
	public void update(Event event);
	
	public void delete(Event event);
}
