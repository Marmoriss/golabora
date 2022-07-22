package com.kh.golabora.review.model.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class Review {
	private String reviewNo;
	private String memberId;
	private String contentsNo;
	private String reviewContent;
	private int star;
	private Date regDate;
	
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Review(String reviewNo, String memberId, String contentsNo, String reviewContent, int star,
			Date regDate) {
		super();
		this.reviewNo = reviewNo;
		this.memberId = memberId;
		this.contentsNo = contentsNo;
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

	public String getContentsNo() {
		return contentsNo;
	}

	public void setContentsNo(String contentsNo) {
		this.contentsNo = contentsNo;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Review [reviewNo=" + reviewNo + ", memberId=" + memberId + ", contentsNo=" + contentsNo
				+ ", reviewContent=" + reviewContent + ", star=" + star + ", regDate=" + regDate + "]";
	}
	
	
}
