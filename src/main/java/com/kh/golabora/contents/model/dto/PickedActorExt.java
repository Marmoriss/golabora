package com.kh.golabora.contents.model.dto;

public class PickedActorExt {
	
	private String memberId;
	private String actorNo;
	private String actorName;
	private Gender gender;
	
	public PickedActorExt() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PickedActorExt(String memberId, String actorNo, String actorName, Gender gender) {
		super();
		this.memberId = memberId;
		this.actorNo = actorNo;
		this.actorName = actorName;
		this.gender = gender;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
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
		return "PickedActor [memberId=" + memberId + ", actorNo=" + actorNo + ", actorName=" + actorName + ", gender="
				+ gender + "]";
	}
	
	

	
}
