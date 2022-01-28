package com.chainsys.dao;

import com.chainsys.model.User;

public interface AdminDAOInterface {
	public  User validateAdmin(String email,String password);

}
