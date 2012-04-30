package com.oak.babybook.services;

import java.util.List;

import com.oak.babybook.objects.Event;
import com.oak.babybook.objects.Person;
import com.oak.babybook.objects.Picture;
import com.oak.babybook.objects.User;

public interface UserService {

	public User getUser(Long id);

	public void insertUser(User user);

	public List<User> getUsers(List<Long> ids);

	public void updateUser(User user);

	public User getUserByNamePass(String userName, String password) throws Exception;

	public void delete(User user);

	public void removeChildFromUser(User user, Long personId);

	public void removeEventFromUser(User user, Long eventId);

	public void removePictureFromUser(User user, Long pictureId);
}
