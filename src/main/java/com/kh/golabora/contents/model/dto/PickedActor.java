package com.kh.golabora.contents.model.dto;

public class PickedActor {
	
	private String memberId;
	private String actorNo;
	
	public PickedActor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PickedActor(String memberId, String actorNo) {
		super();
		this.memberId = memberId;
		this.actorNo = actorNo;
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

	@Override
	public String toString() {
		return "PickedActor [memberId=" + memberId + ", actorNo=" + actorNo + "]";
	}

	
}
