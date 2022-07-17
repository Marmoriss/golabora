package com.kh.golabora.contents.model.dto;

public class ContentsByProducer {

	private String contentsNo;
	private String producerNo;
	
	public ContentsByProducer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContentsByProducer(String contentsNo, String producerNo) {
		super();
		this.contentsNo = contentsNo;
		this.producerNo = producerNo;
	}

	public String getContentsNo() {
		return contentsNo;
	}

	public void setContentsNo(String contentsNo) {
		this.contentsNo = contentsNo;
	}

	public String getProducerNo() {
		return producerNo;
	}

	public void setProducerNo(String producerNo) {
		this.producerNo = producerNo;
	}

	@Override
	public String toString() {
		return "ContentsByProducer [contentsNo=" + contentsNo + ", producerNo=" + producerNo + "]";
	}
	
	
}
