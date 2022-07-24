package com.kh.golabora.contents.model.dto;

public class PickedProducer {

	private String memberId;
	private String producerNo;
	
	public PickedProducer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PickedProducer(String memberId, String producerNo) {
		super();
		this.memberId = memberId;
		this.producerNo = producerNo;
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
	
	@Override
	public String toString() {
		return "PickedProducer [memberId=" + memberId + ", producerNo=" + producerNo + "]";
	}
	
	
}
