package com.oak.babybook.db;

import java.util.List;

import com.oak.babybook.objects.Event;
import com.oak.babybook.objects.User;

public interface UserDao {

	public void insertUser(User user);
	
	public User getUser(Long id);
	
	public List<User> getUsers(List<Long> ids);
	
	public void updateUser(User user);
	
	public void delete(User user);
}