package com.chainsys.model;
import java.util.Objects;

public class User {
	private int userId;
	private String name;
	private String emailId;
	private String password;
	private String subscriber;
	
	
	public String getSubscriber() {
		return subscriber;
	}
	public void setSubscriber(String subscriber) {
		this.subscriber = subscriber;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", emailId=" + emailId + ", password=" + password
				+ ", subscriber=" + subscriber + "]";
	}
	public User() {
		super();

	}
	public User(int userId, String name, String emailId, String password, String subscriber) {
		super();
		this.userId = userId;
		this.name = name;
		this.emailId = emailId;
		this.password = password;
		this.subscriber = subscriber;
	}
	@Override
	public int hashCode() {
		return Objects.hash(emailId, name, password, subscriber, userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(emailId, other.emailId) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && Objects.equals(subscriber, other.subscriber)
				&& userId == other.userId;
	}
	
	
}

