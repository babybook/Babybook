package com.oak.babybook.services.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.oak.babybook.db.impl.UserDaoImpl;
import com.oak.babybook.objects.Event;
import com.oak.babybook.objects.Person;
import com.oak.babybook.objects.Picture;
import com.oak.babybook.objects.User;
import com.oak.babybook.services.UserService;

public class UserServiceImpl implements UserService {

	private UserDaoImpl userDao;

	public UserServiceImpl(UserDaoImpl userDao){
		this.userDao = userDao;
	}

	@Override
	public User getUser(Long id) {
		return this.userDao.getUser(id);
	}

	@Override
	public List<User> getUsers(List<Long> ids) {
		return this.userDao.getUsers(ids);
	}

	@Override
	public void insertUser(User user) {
		this.userDao.insertUser(user);
	}

	@Override
	public void updateUser(User user) {
		this.userDao.updateUser(user);
	}

	@Override
	public User getUserByNamePass(String userName, String password) throws Exception {
		return this.userDao.getUserByNamePass(userName, password);
	}

	@Override
	public void delete(User user) {
		this.userDao.delete(user);
	}

	public void removeChildFromUser(User user, Long personId) {
		Set<Person> children = user.getChildren();
		Set<Person> newChildren = new HashSet<Person>();

		for (Person person : children){
			if (!person.getId().equals(personId)){
				newChildren.add(person);
			}
		}
		user.setChildren(newChildren);
	}

	public void removeEventFromUser(User user, Long eventId) {
		Set<Event> events = user.getEvents();
		Set<Event> newEvents = new HashSet<Event>();

		for (Event event : events){
			if (!event.getId().equals(eventId)){
				newEvents.add(event);
			}
		}
		user.setEvents(newEvents);
	}

	public void removePictureFromUser(User user, Long pictureId) {
		Set<Picture> pictures = user.getPictures();
		Set<Picture> newPictures = new HashSet<Picture>();

		for (Picture picture : pictures){
			if (!picture.getId().equals(pictureId)){
				newPictures.add(picture);
			}
		}
		user.setPictures(newPictures);
	}


}
