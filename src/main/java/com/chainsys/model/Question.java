package com.chainsys.model;

import java.util.Objects;

public class Question {
	
	private int questionId;
	private String questions;
	private int sectionId;
	private String status;
	
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestions() {
		return questions;
	}
	public void setQuestions(String questions) {
		this.questions = questions;
	}
	public int getSectionId() {
		return sectionId;
	}
	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questions=" + questions + ", sectionId=" + sectionId
				+ ", status=" + status + "]";
	}
	public Question() {
		super();

	}
	public Question(int questionId, String questions, int sectionId, String status) {
		super();
		this.questionId = questionId;
		this.questions = questions;
		this.sectionId = sectionId;
		this.status = status;
	}
	@Override
	public int hashCode() {
		return Objects.hash(questionId, questions, sectionId, status);
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
		return questionId == other.questionId && Objects.equals(questions, other.questions)
				&& sectionId == other.sectionId && Objects.equals(status, other.status);
	}
	
	

}
