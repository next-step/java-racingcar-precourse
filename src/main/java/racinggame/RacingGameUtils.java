package racinggame;

public class RacingGameUtils {
	private final int MIN_NUMBER = 0;
	private final int MAX_NUMBER = 9;

	public Boolean validationRandomNumber(int randomNumber) {
		return randomNumber >= MIN_NUMBER && randomNumber <= MAX_NUMBER;
	}
}
