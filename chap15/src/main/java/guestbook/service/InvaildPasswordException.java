package guestbook.service;

public class InvaildPasswordException extends ServiceException{

	public InvaildPasswordException(String message) {
		super(message);
	}
}

