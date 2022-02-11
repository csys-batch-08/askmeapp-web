package com.chainsys.model;

import java.util.Objects;

public class User {
	private int useriId;
	private String username;
	private String emailid;
	private String passWord;
	private String subScriber;
	public int getUseriId() {
		return useriId;
	}
	public void setUseriId(int useriId) {
		this.useriId = useriId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getSubScriber() {
		return subScriber;
	}
	public void setSubScriber(String subScriber) {
		this.subScriber = subScriber;
	}
	@Override
	public String toString() {
		return "User [useriId=" + useriId + ", username=" + username + ", emailid=" + emailid + ", passWord=" + passWord
				+ ", subScriber=" + subScriber + "]";
	}
	public User() {
		super();

	}
	public User(int useriId, String username, String emailid, String passWord, String subScriber) {
		super();
		this.useriId = useriId;
		this.username = username;
		this.emailid = emailid;
		this.passWord = passWord;
		this.subScriber = subScriber;
	}
	@Override
	public int hashCode() {
		return Objects.hash(emailid, passWord, subScriber, useriId, username);
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
		return Objects.equals(emailid, other.emailid) && Objects.equals(passWord, other.passWord)
				&& Objects.equals(subScriber, other.subScriber) && useriId == other.useriId
				&& Objects.equals(username, other.username);
	}
	
	
	
	
}

