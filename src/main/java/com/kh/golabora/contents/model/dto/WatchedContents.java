package com.kh.golabora.contents.model.dto;

public class WatchedContents {

	private String contentsNo;
	private String memberId;
	
	public WatchedContents() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public WatchedContents(String contentsNo, String memberId) {
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
		return "WatchedContents [contentsNo=" + contentsNo + ", memberId=" + memberId + "]";
	}
	
	
}
