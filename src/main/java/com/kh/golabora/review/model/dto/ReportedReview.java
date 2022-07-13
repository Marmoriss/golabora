package com.kh.golabora.review.model.dto;

import java.sql.Date;

public class ReportedReview {
	private String reportedReviewNo;
	private String reviewNo;
	private String reporterId;
	private Date reportedDate;
	private String reason;
	
	public ReportedReview() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReportedReview(String reportedReviewNo, String reviewNo, String reporterId, Date reportedDate,
			String reason) {
		super();
		this.reportedReviewNo = reportedReviewNo;
		this.reviewNo = reviewNo;
		this.reporterId = reporterId;
		this.reportedDate = reportedDate;
		this.reason = reason;
	}

	public String getReportedReviewNo() {
		return reportedReviewNo;
	}

	public void setReportedReviewNo(String reportedReviewNo) {
		this.reportedReviewNo = reportedReviewNo;
	}

	public String getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(String reviewNo) {
		this.reviewNo = reviewNo;
	}

	public String getReporterId() {
		return reporterId;
	}

	public void setReporterId(String reporterId) {
		this.reporterId = reporterId;
	}

	public Date getReportedDate() {
		return reportedDate;
	}

	public void setReportedDate(Date reportedDate) {
		this.reportedDate = reportedDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "ReportedReview [reportedReviewNo=" + reportedReviewNo + ", reviewNo=" + reviewNo + ", reporterId="
				+ reporterId + ", reportedDate=" + reportedDate + ", reason=" + reason + "]";
	}
	
	
}
