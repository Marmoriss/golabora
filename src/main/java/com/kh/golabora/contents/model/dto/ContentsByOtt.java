package com.kh.golabora.contents.model.dto;

public class ContentsByOtt {
	
	private String ottCode;
	private String contentNo;
	
	public ContentsByOtt() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContentsByOtt(String ottCode, String contentNo) {
		super();
		this.ottCode = ottCode;
		this.contentNo = contentNo;
	}

	public String getOttCode() {
		return ottCode;
	}

	public void setOttCode(String ottCode) {
		this.ottCode = ottCode;
	}

	public String getContentNo() {
		return contentNo;
	}

	public void setContentNo(String contentNo) {
		this.contentNo = contentNo;
	}

	@Override
	public String toString() {
		return "ContentsByOtt [ottCode=" + ottCode + ", contentNo=" + contentNo + "]";
	}

	
}
