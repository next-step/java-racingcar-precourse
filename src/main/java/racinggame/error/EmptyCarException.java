package racinggame.error;

public class EmptyCarException extends RuntimeException{
	public EmptyCarException() { super(ErrorMessage.CARNAME_IS_EMPTY); }

}
