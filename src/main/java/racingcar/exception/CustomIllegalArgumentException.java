package racingcar.exception;

public class CustomIllegalArgumentException extends IllegalArgumentException implements ErrorMessage{
	private static final long serialVersionUID = 1L;

	public CustomIllegalArgumentException(String message){
		super(PREFIX_ERROR_MESSAGE+message);
	}
}
