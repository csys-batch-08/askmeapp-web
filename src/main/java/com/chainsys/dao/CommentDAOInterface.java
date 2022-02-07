package com.chainsys.dao;

import java.sql.SQLException;
import java.util.List;

import com.chainsys.model.Comment;

public interface CommentDAOInterface {
	public void insertComment(Comment comment) throws SQLException;	
	public int findCommentId(int sectionId) throws SQLException;
	public void deletedetails(int commentId) throws SQLException;
	public  List<Comment> showAllComment() throws SQLException;
}
