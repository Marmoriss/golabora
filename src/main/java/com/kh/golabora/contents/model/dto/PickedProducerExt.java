package com.kh.golabora.contents.model.dto;

public class PickedProducerExt {

	private String memberId;
	private String producerNo;
	private String producerName;
	private Gender gender;
	
	public PickedProducerExt() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PickedProducerExt(String memberId, String producerNo, String producerName, Gender gender) {
		super();
		this.memberId = memberId;
		this.producerNo = producerNo;
		this.producerName = producerName;
		this.gender = gender;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getProducerNo() {
		return producerNo;
	}

	public void setProducerNo(String producerNo) {
		this.producerNo = producerNo;
	}

	public String getProducerName() {
		return producerName;
	}

	public void setProducerName(String producerName) {
		this.producerName = producerName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "PickedProducer [memberId=" + memberId + ", producerNo=" + producerNo + ", producerName=" + producerName
				+ ", gender=" + gender + "]";
	}
	
}
