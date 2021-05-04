package racing.game.domain.player;

import racing.game.properties.RacingMessage;
import racing.game.util.Validator;

public class ReceivedLapCount {
	private String receivedNameText;
	private boolean validated;

	public ReceivedLapCount(String receivedNameText) {
		this.receivedNameText = receivedNameText.trim();
		validated = true;
		validateLapCount();
	}

	private void validateLapCount() {
		if (!Validator.isNumeric(receivedNameText)) {
			System.out.println(RacingMessage.VALID_NUMERIC);
			validated = false;
		}
	}

	public int getLapCount() {
		return Integer.parseInt(receivedNameText);
	}

	public boolean isValidated() {
		return validated;
	}
}
