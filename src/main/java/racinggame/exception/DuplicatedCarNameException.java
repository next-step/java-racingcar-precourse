package racinggame.exception;

public class DuplicatedCarNameException extends IllegalArgumentException {
	private static final String EXCEPTION_MESSAGE = "Can not create Cars instance. Because of There is a duplicate car name.";

	public DuplicatedCarNameException() {
		super(EXCEPTION_MESSAGE);
	}
}
