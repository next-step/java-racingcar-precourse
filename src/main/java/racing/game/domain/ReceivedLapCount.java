package racing.game.domain;

import java.util.List;

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
			System.out.println("숫자 형식이 아닙니다.");
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
