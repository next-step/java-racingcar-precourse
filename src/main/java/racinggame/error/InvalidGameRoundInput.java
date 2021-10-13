package racinggame.error;

public class InvalidGameRoundInput extends RuntimeException {
	public InvalidGameRoundInput() {
		super(ErrorMessage.INVALID_GAME_ROUND_INPUT);
	}

}
