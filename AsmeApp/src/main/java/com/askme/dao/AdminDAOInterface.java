package com.askme.dao;

import com.askme.model.User;

public interface AdminDAOInterface {
	public  User validateAdmin(String email,String password);

}
