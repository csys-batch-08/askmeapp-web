package com.askmeapp.model;

import java.util.Objects;

public class AdminCommentView {
	private String email;
	private String comment;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "AdminCommentView [email=" + email + ", comment=" + comment + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(comment, email);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdminCommentView other = (AdminCommentView) obj;
		return Objects.equals(comment, other.comment) && Objects.equals(email, other.email);
	}
	public AdminCommentView(String email, String comment) {
		super();
		this.email = email;
		this.comment = comment;
	}
	public AdminCommentView() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
