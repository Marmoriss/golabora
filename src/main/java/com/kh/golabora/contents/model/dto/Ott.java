package com.kh.golabora.contents.model.dto;

public class Ott {
	private String ottCode;
	private String ottName;
	
	public Ott() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Ott(String ottCode, String ottName) {
		super();
		this.ottCode = ottCode;
		this.ottName = ottName;
	}
	
	public String getOttCode() {
		return ottCode;
	}
	public void setOttCode(String ottCode) {
		this.ottCode = ottCode;
	}
	public String getOttName() {
		return ottName;
	}
	public void setOttName(String ottName) {
		this.ottName = ottName;
	}
	
	@Override
	public String toString() {
		return "Ott [ottCode=" + ottCode + ", ottName=" + ottName + "]";
	}
	
	
}
