package com.kh.golabora.contents.model.dto;

public class Producer {

	private String producerNo;
	private String producerName;
	private Gender gender;
	
	public Producer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Producer(String producerNo, String producerName, Gender gender) {
		super();
		this.producerNo = producerNo;
		this.producerName = producerName;
		this.gender = gender;
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
		return "Producer [producerNo=" + producerNo + ", producerName=" + producerName + ", gender=" + gender + "]";
	}
	
	
}
