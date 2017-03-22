package com.icontrols.test;

import java.util.HashMap;

public interface UserService {
	
	public void insertUser(HashMap<String, Object> map);
	public int loginCheck(HashMap<String, Object> map);
}
