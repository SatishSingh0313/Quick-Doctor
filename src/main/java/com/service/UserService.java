package com.service;

import com.entity.User;

public interface UserService {

	public Object SaveData(User u);
	public Object login(String email_id , String password);
	public Object forgotPassword(String email_id , String password);
	public Object findByUserName(String userName);
	public Object findByEmail(String emailId);
}
