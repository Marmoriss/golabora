package com.kh.golabora.contents.model.dto;

public class PickedContents {

	private String contentNo;
	private String memberId;
	
	public PickedContents() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PickedContents(String contentNo, String memberId) {
		super();
		this.contentNo = contentNo;
		this.memberId = memberId;
	}

	public String getContentNo() {
		return contentNo;
	}

	public void setContentNo(String contentNo) {
		this.contentNo = contentNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return "PickedContents [contentNo=" + contentNo + ", memberId=" + memberId + "]";
	}
	
	
	
}
