package app;

public class NameException extends Exception {

	private String message;

	public NameException() {
	}

	public NameException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return message;
	}

}
