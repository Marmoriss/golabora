package com.kh.golabora.member.model.dto;

import java.sql.Timestamp;

public class Member {
	private String memberId;
	private String genreCode;
	private String password;
	private String memberName;
	private Gender gender;
	private String phone;
	private MemberRole memberRole;
	private Timestamp enrollDate;
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(String memberId, String genreCode, String password, String memberName, Gender gender, String phone,
			MemberRole memberRole, Timestamp enrollDate) {
		super();
		this.memberId = memberId;
		this.genreCode = genreCode;
		this.password = password;
		this.memberName = memberName;
		this.gender = gender;
		this.phone = phone;
		this.memberRole = memberRole;
		this.enrollDate = enrollDate;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getGenreCode() {
		return genreCode;
	}

	public void setGenreCode(String genreCode) {
		this.genreCode = genreCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public MemberRole getMemberRole() {
		return memberRole;
	}

	public void setMemberRole(MemberRole memberRole) {
		this.memberRole = memberRole;
	}

	public Timestamp getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Timestamp enrollDate) {
		this.enrollDate = enrollDate;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", genreCode=" + genreCode + ", password=" + password + ", memberName="
				+ memberName + ", gender=" + gender + ", phone=" + phone + ", memberRole=" + memberRole
				+ ", enrollDate=" + enrollDate + "]";
	}
	
	
}
