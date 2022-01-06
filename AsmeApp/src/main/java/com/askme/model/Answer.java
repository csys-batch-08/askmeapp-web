package com.askme.model;

import java.util.Objects;

public class Answer {
	
	private String answer;
	private int question_id;
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	@Override
	public String toString() {
		return "Answer [answer=" + answer + ", question_id=" + question_id + "]";
	}
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Answer(String answer, int question_id) {
		super();
		this.answer = answer;
		this.question_id = question_id;
	}
	@Override
	public int hashCode() {
		return Objects.hash(answer, question_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Answer other = (Answer) obj;
		return Objects.equals(answer, other.answer) && question_id == other.question_id;
	}
	

}
