package com.kh.golabora.contents.model.dto;

public class ContentsWithActor extends Contents{

	private String actorNo;
	private String actorName;
	private Gender gender;
	
	public ContentsWithActor() {
		super();
	}
	
	public ContentsWithActor(String contentsNo, String genreCode, int watchableAge, String contentsTitle,
			String releaseDate, String runningTime, int watchCount, String contentsPlot, String originalFilename,
			String renamedFilename) {
		super(contentsNo, genreCode, watchableAge, contentsTitle, releaseDate, runningTime, watchCount, contentsPlot,
				originalFilename, renamedFilename);
	}
	
	public ContentsWithActor(String actorNo, String actorName, Gender gender) {
		super();
		this.actorNo = actorNo;
		this.actorName = actorName;
		this.gender = gender;
	}
	public String getActorNo() {
		return actorNo;
	}
	public void setActorNo(String actorNo) {
		this.actorNo = actorNo;
	}
	public String getActorName() {
		return actorName;
	}
	public void setActorName(String actorName) {
		this.actorName = actorName;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "ContentsWithActor [actorNo=" + actorNo + ", actorName=" + actorName + ", gender=" + gender + "]";
	}
	
	

}
