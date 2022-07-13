package com.kh.golabora.contents.model.dto;

public class Contents {
	
	private String contentNo;
	private String genreCode;
	private int watchableAge;
	private String contentTitle;
	private String releaseDate;
	private String runningTime;
	private int watchCount;
	private String contentPlot;
	private String originalFilename;
	private String renamedFilename;
	
	public Contents() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contents(String contentNo, String genreCode, int watchableAge, String contentTitle, String releaseDate,
			String runningTime, int watchCount, String contentPlot, String originalFilename, String renamedFilename) {
		super();
		this.contentNo = contentNo;
		this.genreCode = genreCode;
		this.watchableAge = watchableAge;
		this.contentTitle = contentTitle;
		this.releaseDate = releaseDate;
		this.runningTime = runningTime;
		this.watchCount = watchCount;
		this.contentPlot = contentPlot;
		this.originalFilename = originalFilename;
		this.renamedFilename = renamedFilename;
	}

	public String getContentNo() {
		return contentNo;
	}

	public void setContentNo(String contentNo) {
		this.contentNo = contentNo;
	}

	public String getGenreCode() {
		return genreCode;
	}

	public void setGenreCode(String genreCode) {
		this.genreCode = genreCode;
	}

	public int getWatchableAge() {
		return watchableAge;
	}

	public void setWatchableAge(int watchableAge) {
		this.watchableAge = watchableAge;
	}

	public String getContentTitle() {
		return contentTitle;
	}

	public void setContentTitle(String contentTitle) {
		this.contentTitle = contentTitle;
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

	public int getWatchCount() {
		return watchCount;
	}

	public void setWatchCount(int watchCount) {
		this.watchCount = watchCount;
	}

	public String getContentPlot() {
		return contentPlot;
	}

	public void setContentPlot(String contentPlot) {
		this.contentPlot = contentPlot;
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

	@Override
	public String toString() {
		return "Contents [contentNo=" + contentNo + ", genreCode=" + genreCode + ", watchableAge=" + watchableAge
				+ ", contentTitle=" + contentTitle + ", releaseDate=" + releaseDate + ", runningTime=" + runningTime
				+ ", watchCount=" + watchCount + ", contentPlot=" + contentPlot + ", originalFilename="
				+ originalFilename + ", renamedFilename=" + renamedFilename + "]";
	}
	
	
}
