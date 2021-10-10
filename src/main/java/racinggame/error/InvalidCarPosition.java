package racinggame.error;

public class InvalidCarPosition extends RuntimeException{
	public InvalidCarPosition() { super(ErrorMessage.INVALID_CAR_POSITION); }

}
