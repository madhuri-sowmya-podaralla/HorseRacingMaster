package com.intenthq.exception;

@SuppressWarnings("serial")
public class InvalidNumberOfPlayersException extends Exception {

	public InvalidNumberOfPlayersException(String message){
		super(message);
	}
}
