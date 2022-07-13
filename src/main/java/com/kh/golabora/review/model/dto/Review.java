package com.kh.golabora.review.model.dto;

import java.sql.Timestamp;

public class Review {
	private String reviewNo;
	private String memberId;
	private String contentNo;
	private String reviewContent;
	private String star;
	private Timestamp regDate;
	
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Review(String reviewNo, String memberId, String contentNo, String reviewContent, String star,
			Timestamp regDate) {
		super();
		this.reviewNo = reviewNo;
		this.memberId = memberId;
		this.contentNo = contentNo;
		this.reviewContent = reviewContent;
		this.star = star;
		this.regDate = regDate;
	}

	public String getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(String reviewNo) {
		this.reviewNo = reviewNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getContentNo() {
		return contentNo;
	}

	public void setContentNo(String contentNo) {
		this.contentNo = contentNo;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public String getStar() {
		return star;
	}

	public void setStar(String star) {
		this.star = star;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Review [reviewNo=" + reviewNo + ", memberId=" + memberId + ", contentNo=" + contentNo
				+ ", reviewContent=" + reviewContent + ", star=" + star + ", regDate=" + regDate + "]";
	}
	
	
}
