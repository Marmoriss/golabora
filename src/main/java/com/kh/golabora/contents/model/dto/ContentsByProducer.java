package com.kh.golabora.contents.model.dto;

public class ContentsByProducer {

	private String contentNo;
	private String producerNo;
	
	public ContentsByProducer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContentsByProducer(String contentNo, String producerNo) {
		super();
		this.contentNo = contentNo;
		this.producerNo = producerNo;
	}

	public String getContentNo() {
		return contentNo;
	}

	public void setContentNo(String contentNo) {
		this.contentNo = contentNo;
	}

	public String getProducerNo() {
		return producerNo;
	}

	public void setProducerNo(String producerNo) {
		this.producerNo = producerNo;
	}

	@Override
	public String toString() {
		return "ContentsByProducer [contentNo=" + contentNo + ", producerNo=" + producerNo + "]";
	}
	
	
}
