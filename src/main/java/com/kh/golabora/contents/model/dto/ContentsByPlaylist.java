package com.kh.golabora.contents.model.dto;

public class ContentsByPlaylist {

	private String playlistNo;
	private String contentsNo;
	private String contentsTitle;
	private String contentsImg;
	private String runningTime;
	private int watchableAge;
	
	public ContentsByPlaylist() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ContentsByPlaylist(String playlistNo, String contentsNo, String contentsTitle, String contentsImg,
			String runningTime, int watchableAge) {
		super();
		this.playlistNo = playlistNo;
		this.contentsNo = contentsNo;
		this.contentsTitle = contentsTitle;
		this.contentsImg = contentsImg;
		this.runningTime = runningTime;
		this.watchableAge = watchableAge;
	}
	public String getPlaylistNo() {
		return playlistNo;
	}
	public void setPlaylistNo(String playlistNo) {
		this.playlistNo = playlistNo;
	}
	public String getContentsNo() {
		return contentsNo;
	}
	public void setContentsNo(String contentsNo) {
		this.contentsNo = contentsNo;
	}
	public String getContentsTitle() {
		return contentsTitle;
	}
	public void setContentsTitle(String contentsTitle) {
		this.contentsTitle = contentsTitle;
	}
	public String getContentsImg() {
		return contentsImg;
	}
	public void setContentsImg(String contentsImg) {
		this.contentsImg = contentsImg;
	}
	public String getRunningTime() {
		return runningTime;
	}
	public void setRunningTime(String runningTime) {
		this.runningTime = runningTime;
	}
	public int getWatchableAge() {
		return watchableAge;
	}
	public void setWatchableAge(int watchableAge) {
		this.watchableAge = watchableAge;
	}
	@Override
	public String toString() {
		return "ContentsByPlaylist [playlistNo=" + playlistNo + ", contentsNo=" + contentsNo + ", contentsTitle="
				+ contentsTitle + ", contentsImg=" + contentsImg + ", runningTime=" + runningTime + ", watchableAge="
				+ watchableAge + "]";
	}
	
	
}
