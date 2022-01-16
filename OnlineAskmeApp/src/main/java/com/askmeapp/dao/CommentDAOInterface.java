package com.askmeapp.dao;

import java.sql.ResultSet;


import com.askmeapp.model.Comment;

public interface CommentDAOInterface {
	public void insertComment(Comment comment);
		public  ResultSet showAllComment();

}
