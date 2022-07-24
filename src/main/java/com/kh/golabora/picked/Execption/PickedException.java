package com.kh.golabora.picked.Execption;

public class PickedException extends RuntimeException{
	// PickedException 만들기(insert)
	
	public PickedException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PickedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public PickedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public PickedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public PickedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
