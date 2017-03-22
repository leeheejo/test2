package com.icontrols.test;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

@Repository(value="User")
public interface UserDao {
	
	public void insertUser(HashMap<String, Object> map);
	public int loginCheck(HashMap<String, Object> map);

}
