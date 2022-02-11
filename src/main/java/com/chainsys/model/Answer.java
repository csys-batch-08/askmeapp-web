package com.chainsys.model;

import java.util.Objects;

public class Answer {

	private String answers;
	private int questionId;
	private String status;

	public String getAnswers() {
		return answers;
	}

	public void setAnswers(String answers) {
		this.answers = answers;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Answer() {
		super();

	}

	public Answer(String answers, int questionId, String status) {
		super();
		this.answers = answers;
		this.questionId = questionId;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Answer [answers=" + answers + ", questionId=" + questionId + ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(answers, questionId, status);
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
		return Objects.equals(answers, other.answers) && questionId == other.questionId
				&& Objects.equals(status, other.status);
	}

}
