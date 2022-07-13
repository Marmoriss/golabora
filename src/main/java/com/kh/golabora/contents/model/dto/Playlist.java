package com.kh.golabora.contents.model.dto;

public class Playlist {
	
	private String playlistNo;
	private String memberId;
	private String playlistTitle;
	public Playlist() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Playlist(String playlistNo, String memberId, String playlistTitle) {
		super();
		this.playlistNo = playlistNo;
		this.memberId = memberId;
		this.playlistTitle = playlistTitle;
	}
	
	public String getplaylistNo() {
		return playlistNo;
	}
	public void setplaylistNo(String playlistNo) {
		this.playlistNo = playlistNo;
	}
	public String getmemberId() {
		return memberId;
	}
	public void setmemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getplaylistTitle() {
		return playlistTitle;
	}
	public void setplaylistTitle(String playlistTitle) {
		this.playlistTitle = playlistTitle;
	}
	
	@Override
	public String toString() {
		return "Playlist [playlistNo=" + playlistNo + ", memberId=" + memberId + ", playlistTitle="
				+ playlistTitle + "]";
	}
	
}
