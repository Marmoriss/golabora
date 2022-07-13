package com.kh.golabora.contents.model.dto;

public class ContentsByActor {

	private String contentNo;
	private String actorNo;
	
	public ContentsByActor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContentsByActor(String contentNo, String actorNo) {
		super();
		this.contentNo = contentNo;
		this.actorNo = actorNo;
	}

	public String getContentNo() {
		return contentNo;
	}

	public void setContentNo(String contentNo) {
		this.contentNo = contentNo;
	}

	public String getActorNo() {
		return actorNo;
	}

	public void setActorNo(String actorNo) {
		this.actorNo = actorNo;
	}

	@Override
	public String toString() {
		return "ContentsByActor [contentNo=" + contentNo + ", actorNo=" + actorNo + "]";
	}
	
	
	
}
