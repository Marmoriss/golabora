package com.kh.golabora.contents.model.dto;

public class WatchedContents {

	private String contentNo;
	private String memberId;
	
	public WatchedContents() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public WatchedContents(String contentNo, String memberId) {
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
		return "WatchedContents [contentNo=" + contentNo + ", memberId=" + memberId + "]";
	}
	
	
}
