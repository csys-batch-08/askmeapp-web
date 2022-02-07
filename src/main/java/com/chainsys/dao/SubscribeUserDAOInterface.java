package com.chainsys.dao;

import java.sql.SQLException;
import java.util.List;

import com.chainsys.model.SubscribeUser;
import com.chainsys.model.User;

public interface SubscribeUserDAOInterface {
	public List<SubscribeUser> showAllSection(User user) throws SQLException;
}
