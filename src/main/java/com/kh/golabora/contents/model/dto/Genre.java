package com.kh.golabora.contents.model.dto;

public class Genre {
	private String genreCode;
	private String genreName;
	
	public Genre() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Genre(String genreCode, String genreName) {
		super();
		this.genreCode = genreCode;
		this.genreName = genreName;
	}

	public String getGenreCode() {
		return genreCode;
	}

	public void setGenreCode(String genreCode) {
		this.genreCode = genreCode;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	@Override
	public String toString() {
		return "Genre [genreCode=" + genreCode + ", genreName=" + genreName + "]";
	}
	
	
	
	
}
