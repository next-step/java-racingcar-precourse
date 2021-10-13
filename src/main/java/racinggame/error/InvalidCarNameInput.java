package racinggame.error;

public class InvalidCarNameInput extends RuntimeException {
	public InvalidCarNameInput() {
		super(ErrorMessage.INVALID_CAR_NAME_INPUT);
	}

}
