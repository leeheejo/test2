package com.icontrols.test;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	@Override
	public void insertUser(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		userDao.insertUser(map);
		
	}
	@Override
	public int loginCheck(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return userDao.loginCheck(map);
	}

}
