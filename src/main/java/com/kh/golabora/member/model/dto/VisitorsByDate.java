package com.kh.golabora.member.model.dto;

import java.sql.Date;

public class VisitorsByDate {

	private String viewDate;
	private Date visitors;
	
	public VisitorsByDate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VisitorsByDate(String viewDate, Date visitors) {
		super();
		this.viewDate = viewDate;
		this.visitors = visitors;
	}

	public String getviewDate() {
		return viewDate;
	}

	public void setviewDate(String viewDate) {
		this.viewDate = viewDate;
	}

	public Date getVisitors() {
		return visitors;
	}

	public void setVisitors(Date visitors) {
		this.visitors = visitors;
	}

	@Override
	public String toString() {
		return "visitorsByviewDate [viewDate=" + viewDate + ", visitors=" + visitors + "]";
	}
}
