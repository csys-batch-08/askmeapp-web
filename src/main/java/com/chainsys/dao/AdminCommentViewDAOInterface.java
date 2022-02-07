package com.chainsys.dao;

import java.sql.SQLException;
import java.util.List;

import com.chainsys.model.AdminCommentView;

public interface AdminCommentViewDAOInterface {
	public List<AdminCommentView> commentView() throws SQLException;

}
