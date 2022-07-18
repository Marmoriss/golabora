package com.kh.golabora.contents.model.dto;

public class ContentsWithProducer extends Contents{

	private String producerNo;
	private String producerName;
	private Gender gender;
	
	public ContentsWithProducer() {
		super();
	}
	
	public ContentsWithProducer(String contentsNo, String genreCode, int watchableAge, String contentsTitle,
			String releaseDate, String runningTime, int watchCount, String contentsPlot, String originalFilename,
			String renamedFilename) {
		super(contentsNo, genreCode, watchableAge, contentsTitle, releaseDate, runningTime, watchCount, contentsPlot,
				originalFilename, renamedFilename);
	}
	
	public ContentsWithProducer(String producerNo, String producerName, Gender gender) {
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
		return "ContentsWithProducer [producerNo=" + producerNo + ", producerName=" + producerName + ", gender="
				+ gender + "]";
	}
	
	
	
}
