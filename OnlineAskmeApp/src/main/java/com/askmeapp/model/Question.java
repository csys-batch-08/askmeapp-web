package com.askmeapp.model;

import java.util.Objects;

public class Question {
	private String question;
	private int sectionId;
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public int getSectionId() {
		return sectionId;
	}
	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}
	@Override
	public String toString() {
		return "Question [question=" + question + ", sectionId=" + sectionId + "]";
	}
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Question(String question, int sectionId) {
		super();
		this.question = question;
		this.sectionId = sectionId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(question, sectionId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		return Objects.equals(question, other.question) && sectionId == other.sectionId;
	}
	
	

}
