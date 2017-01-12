package com.ittx.studentmanger.dao;

import com.ittx.studentmanger.model.User;

public abstract interface UserDao {
	  void addUser(User user);

	User checkUser(String userName, String passWord);
	
}
