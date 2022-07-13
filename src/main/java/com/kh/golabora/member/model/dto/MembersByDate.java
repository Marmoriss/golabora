package com.kh.golabora.member.model.dto;

import java.sql.Date;

public class MembersByDate {

	private String viewDate;
	private Date numberOfMember;
	
	public MembersByDate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MembersByDate(String viewDate, Date numberOfMember) {
		super();
		this.viewDate = viewDate;
		this.numberOfMember = numberOfMember;
	}

	public String getViewDate() {
		return viewDate;
	}

	public void setViewDate(String viewDate) {
		this.viewDate = viewDate;
	}

	public Date getNumberOfMember() {
		return numberOfMember;
	}

	public void setNumberOfMember(Date numberOfMember) {
		this.numberOfMember = numberOfMember;
	}

	
	@Override
	public String toString() {
		return "MembersByDate [viewDate=" + viewDate + ", numberOfMember=" + numberOfMember + "]";
	}
	
	
}
