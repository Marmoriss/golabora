package com.kh.golabora.contents.model.dto;

public class ContentsInfo {

	private String contentsNo;
	private int watchableAge;
	private String contentsTitle;
	private String releaseDate;
	private String runningTime;
	private String contentsPlot;
	private String originalFilename;
	private String renamedFilename;
	private String genreName;
	private String ottName;
	private String actorName;
	private String producerName;
	
	public ContentsInfo() {
		super();
	}

	public ContentsInfo(String contentsNo, int watchableAge, String contentsTitle, String releaseDate,
			String runningTime, String contentsPlot, String originalFilename, String renamedFilename, String genreName,
			String ottName, String actorName, String producerName) {
		super();
		this.contentsNo = contentsNo;
		this.watchableAge = watchableAge;
		this.contentsTitle = contentsTitle;
		this.releaseDate = releaseDate;
		this.runningTime = runningTime;
		this.contentsPlot = contentsPlot;
		this.originalFilename = originalFilename;
		this.renamedFilename = renamedFilename;
		this.genreName = genreName;
		this.ottName = ottName;
		this.actorName = actorName;
		this.producerName = producerName;
	}

	public String getContentsNo() {
		return contentsNo;
	}

	public void setContentsNo(String contentsNo) {
		this.contentsNo = contentsNo;
	}

	public int getWatchableAge() {
		return watchableAge;
	}

	public void setWatchableAge(int watchableAge) {
		this.watchableAge = watchableAge;
	}

	public String getContentsTitle() {
		return contentsTitle;
	}

	public void setContentsTitle(String contentsTitle) {
		this.contentsTitle = contentsTitle;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getRunningTime() {
		return runningTime;
	}

	public void setRunningTime(String runningTime) {
		this.runningTime = runningTime;
	}

	public String getContentsPlot() {
		return contentsPlot;
	}

	public void setContentsPlot(String contentsPlot) {
		this.contentsPlot = contentsPlot;
	}

	public String getOriginalFilename() {
		return originalFilename;
	}

	public void setOriginalFilename(String originalFilename) {
		this.originalFilename = originalFilename;
	}

	public String getRenamedFilename() {
		return renamedFilename;
	}

	public void setRenamedFilename(String renamedFilename) {
		this.renamedFilename = renamedFilename;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	public String getOttName() {
		return ottName;
	}

	public void setOttName(String ottName) {
		this.ottName = ottName;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public String getProducerName() {
		return producerName;
	}

	public void setProducerName(String producerName) {
		this.producerName = producerName;
	}

	@Override
	public String toString() {
		return "ContentsInfo [contentsNo=" + contentsNo + ", watchableAge=" + watchableAge + ", contentsTitle="
				+ contentsTitle + ", releaseDate=" + releaseDate + ", runningTime=" + runningTime + ", contentsPlot="
				+ contentsPlot + ", originalFilename=" + originalFilename + ", renamedFilename=" + renamedFilename
				+ ", genreName=" + genreName + ", ottName=" + ottName + ", actorName=" + actorName + ", producerName="
				+ producerName + "]";
	}
	
	
}
