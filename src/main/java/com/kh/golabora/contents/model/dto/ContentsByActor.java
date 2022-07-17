package com.kh.golabora.contents.model.dto;

public class ContentsByActor {

	private String contentsNo;
	private String actorNo;
	
	public ContentsByActor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContentsByActor(String contentsNo, String actorNo) {
		super();
		this.contentsNo = contentsNo;
		this.actorNo = actorNo;
	}

	public String getContentsNo() {
		return contentsNo;
	}

	public void setContentsNo(String contentsNo) {
		this.contentsNo = contentsNo;
	}

	public String getActorNo() {
		return actorNo;
	}

	public void setActorNo(String actorNo) {
		this.actorNo = actorNo;
	}

	@Override
	public String toString() {
		return "ContentsByActor [contentsNo=" + contentsNo + ", actorNo=" + actorNo + "]";
	}
	
	
	
}
