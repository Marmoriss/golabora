package com.kh.golabora.contents.model.dto;

public class PickedProducerExt extends PickedProducer{

	private String producerName;
	private Gender gender;
	
	public PickedProducerExt() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PickedProducerExt(String memberId, String producerNo) {
		super(memberId, producerNo);
		// TODO Auto-generated constructor stub
	}
	
	public PickedProducerExt(String producerName, Gender gender) {
		super();
		this.producerName = producerName;
		this.gender = gender;
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
		return "PickedProducerExt [producerName=" + producerName + ", gender=" + gender + "]";
	}
	
	
}
