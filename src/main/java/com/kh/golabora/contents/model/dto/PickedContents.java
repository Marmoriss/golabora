package com.kh.golabora.contents.model.dto;

public class PickedContents {

	private String contentsNo;
	private String memberId;
	
	public PickedContents() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PickedContents(String contentsNo, String memberId) {
		super();
		this.contentsNo = contentsNo;
		this.memberId = memberId;
	}

	public String getContentsNo() {
		return contentsNo;
	}

	public void setContentsNo(String contentsNo) {
		this.contentsNo = contentsNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return "PickedContents [contentsNo=" + contentsNo + ", memberId=" + memberId + "]";
	}
	
	
	
}
