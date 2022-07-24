package com.kh.golabora.contents.model.dto;

public class PickedContentsExt extends PickedContents{

	private String genreCode;
	private int watchableAge;
	private String contentsTitle;
	private String releaseDate;
	private String runningTime;
	private int watchCount;
	private String contentsPlot;
	private String originalFilename;
	private String renamedFilename;
	
	public PickedContentsExt() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PickedContentsExt(String contentsNo, String memberId) {
		super(contentsNo, memberId);
		// TODO Auto-generated constructor stub
	}
	
	public PickedContentsExt(String genreCode, int watchableAge, String contentsTitle, String releaseDate,
			String runningTime, int watchCount, String contentsPlot, String originalFilename, String renamedFilename) {
		super();
		this.genreCode = genreCode;
		this.watchableAge = watchableAge;
		this.contentsTitle = contentsTitle;
		this.releaseDate = releaseDate;
		this.runningTime = runningTime;
		this.watchCount = watchCount;
		this.contentsPlot = contentsPlot;
		this.originalFilename = originalFilename;
		this.renamedFilename = renamedFilename;
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
	public int getWatchCount() {
		return watchCount;
	}
	public void setWatchCount(int watchCount) {
		this.watchCount = watchCount;
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
	
	@Override
	public String toString() {
		return "PickedContentsExt [genreCode=" + genreCode + ", watchableAge=" + watchableAge + ", contentsTitle="
				+ contentsTitle + ", releaseDate=" + releaseDate + ", runningTime=" + runningTime + ", watchCount="
				+ watchCount + ", contentsPlot=" + contentsPlot + ", originalFilename=" + originalFilename
				+ ", renamedFilename=" + renamedFilename + "]";
	}
	
	
}
