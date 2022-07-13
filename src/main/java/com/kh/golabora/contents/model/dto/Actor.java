package com.kh.golabora.contents.model.dto;

public class Actor {
	
	private String actorNo;
	private String actorName;
	private Gender gender;
	
	public Actor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Actor(String actorNo, String actorName, Gender gender) {
		super();
		this.actorNo = actorNo;
		this.actorName = actorName;
		this.gender = gender;
	}

	public String getActorNo() {
		return actorNo;
	}

	public void setActorNo(String actorNo) {
		this.actorNo = actorNo;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Actor [actorNo=" + actorNo + ", actorName=" + actorName + ", gender=" + gender + "]";
	}

}
