package com.kh.golabora.contents.model.dto;

public class PickedActorExt extends PickedActor{
	
	private String actorName;
	private Gender gender;
	
	public PickedActorExt() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PickedActorExt(String memberId, String actorNo) {
		super(memberId, actorNo);
		// TODO Auto-generated constructor stub
	}
	
	public PickedActorExt(String actorName, Gender gender) {
		super();
		this.actorName = actorName;
		this.gender = gender;
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
		return "PickedActorExt [actorName=" + actorName + ", gender=" + gender + "]";
	}
	
	
	
}
