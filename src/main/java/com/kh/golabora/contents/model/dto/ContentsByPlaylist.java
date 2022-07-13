package com.kh.golabora.contents.model.dto;

public class ContentsByPlaylist {

	private String playlistNo;
	private String contentNo;
	private String contentTitle;
	private String contentImg;
	private String runningTime;
	private int watchableAge;
	
	public ContentsByPlaylist() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContentsByPlaylist(String playlistNo, String contentNo, String contentTitle, String contentImg,
			String runningTime, int watchableAge) {
		super();
		this.playlistNo = playlistNo;
		this.contentNo = contentNo;
		this.contentTitle = contentTitle;
		this.contentImg = contentImg;
		this.runningTime = runningTime;
		this.watchableAge = watchableAge;
	}

	public String getPlaylistNo() {
		return playlistNo;
	}

	public void setPlaylistNo(String playlistNo) {
		this.playlistNo = playlistNo;
	}

	public String getContentNo() {
		return contentNo;
	}

	public void setContentNo(String contentNo) {
		this.contentNo = contentNo;
	}

	public String getContentTitle() {
		return contentTitle;
	}

	public void setContentTitle(String contentTitle) {
		this.contentTitle = contentTitle;
	}

	public String getContentImg() {
		return contentImg;
	}

	public void setContentImg(String contentImg) {
		this.contentImg = contentImg;
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
		return "contentsByPlaylist [playlistNo=" + playlistNo + ", contentNo=" + contentNo + ", contentTitle="
				+ contentTitle + ", contentImg=" + contentImg + ", runningTime=" + runningTime + ", watchableAge="
				+ watchableAge + "]";
	}
	
}
