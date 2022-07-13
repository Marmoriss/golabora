package com.kh.golabora.contents.model.dto;

import java.sql.Date;

public class WatchcountByContents {
	private String no;
	private Date viewDate;
	private String contentNo;
	private int watchCount;
	
	public WatchcountByContents() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WatchcountByContents(String no, Date viewDate, String contentNo, int watchCount) {
		super();
		this.no = no;
		this.viewDate = viewDate;
		this.contentNo = contentNo;
		this.watchCount = watchCount;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public Date getViewDate() {
		return viewDate;
	}

	public void setViewDate(Date viewDate) {
		this.viewDate = viewDate;
	}

	public String getContentNo() {
		return contentNo;
	}

	public void setContentNo(String contentNo) {
		this.contentNo = contentNo;
	}

	public int getWatchCount() {
		return watchCount;
	}

	public void setWatchCount(int watchCount) {
		this.watchCount = watchCount;
	}

	@Override
	public String toString() {
		return "WatchcountByContents [no=" + no + ", viewDate=" + viewDate + ", contentNo=" + contentNo
				+ ", watchCount=" + watchCount + "]";
	}
	
	
}
