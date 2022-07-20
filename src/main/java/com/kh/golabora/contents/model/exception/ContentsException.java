package com.kh.golabora.contents.model.exception;

public class ContentsException extends RuntimeException{
	// contentsException 만들기(insert)
	
	public ContentsException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContentsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ContentsException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ContentsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ContentsException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
