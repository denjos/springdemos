package com.orion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orion.dao.UserDaoImpl;
import com.orion.model.User;

@Service
public class UserService {
	@Autowired
	private UserDaoImpl userDao;
	
	public List<User> getAllUser()
	{
		return userDao.getAllUser();
	}
}
