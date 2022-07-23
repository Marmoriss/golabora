package com.kh.golabora.review.model.dto;

import java.sql.Date;

public class DeletedReview extends Review{

	private ReportedYn reportedYn;
	private Date deleteDate;
	
	public DeletedReview() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DeletedReview(String reviewNo, String memberId, String contentsNo, String reviewContent, int star,
			Date regDate) {
		super(reviewNo, memberId, contentsNo, reviewContent, star, regDate);
		// TODO Auto-generated constructor stub
	}
	
	public DeletedReview(ReportedYn reportedYn, Date deleteDate) {
		super();
		this.reportedYn = reportedYn;
		this.deleteDate = deleteDate;
	}
	
	public ReportedYn getReportedYn() {
		return reportedYn;
	}
	public void setReportedYn(ReportedYn reportedYn) {
		this.reportedYn = reportedYn;
	}
	public Date getDeleteDate() {
		return deleteDate;
	}
	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}
	
	@Override
	public String toString() {
		return "DeletedReview [reportedYn=" + reportedYn + ", deleteDate=" + deleteDate + "]";
	}
	
	
}
