package com.askmeapp.dao;

import com.askmeapp.model.User;

public interface AdminDAOInterface {
	public  User validateAdmin(String email,String password);

}
