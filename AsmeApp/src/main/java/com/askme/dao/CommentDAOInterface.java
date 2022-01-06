package com.askme.dao;

import java.sql.ResultSet;

import com.askme.model.Comment;

public interface CommentDAOInterface {
	public void insertComment(Comment comment);
		public  ResultSet showAllComment();

}
