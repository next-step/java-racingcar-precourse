package racinggame.error;

public class CarNameLengthException extends RuntimeException{
	public CarNameLengthException() { super(ErrorMessage.CARNAME_IS_TOO_LONG); }
}
