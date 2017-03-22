package com.icontrols.test;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String PATH = "User.";

	@Override
	public void insertUser(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		sqlSession.insert(PATH + "insertUser", map);
	}

	@Override
	public int loginCheck(HashMap<String, Object> map) {
		// TODO Auto-generated method stub

		return sqlSession.selectOne(PATH + "loginCheck", map);
	}

}
