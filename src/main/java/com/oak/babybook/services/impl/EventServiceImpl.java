package com.oak.babybook.services.impl;

import java.util.List;

import com.oak.babybook.db.impl.EventDaoImpl;
import com.oak.babybook.objects.Event;
import com.oak.babybook.objects.Picture;
import com.oak.babybook.services.EventService;

public class EventServiceImpl implements EventService {

	private EventDaoImpl eventDao;

	public EventServiceImpl(EventDaoImpl personDao){
		this.eventDao = personDao;
	}

	@Override
	public Event getEvent(Long id) {
		return this.eventDao.getEvent(id);
	}

	@Override
	public List<Event> getEvents(List<Long> ids) {
		return this.eventDao.getEvents(ids);
	}

	@Override
	public void insertEvent(Event event) {
		this.eventDao.insertEvent(event);
	}

	@Override
	public void update(Event event) {
		this.eventDao.update(event);
	}

	@Override
	public void delete(Event event) {
		this.eventDao.delete(event);
	}
}
