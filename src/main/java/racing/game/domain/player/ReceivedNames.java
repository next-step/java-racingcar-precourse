package racing.game.domain.player;

import java.util.ArrayList;
import java.util.List;

import racing.game.properties.RacingMessage;
import racing.game.util.Validator;

public class ReceivedNames {
	private String receivedNameText;
	private boolean validated;
	private List<String> splittedTextList;

	public ReceivedNames(String receivedNameText) {
		this.receivedNameText = receivedNameText;
		validated = true;
	}

	public void convertList() {
		String[] splittedTexts = receivedNameText.split(",");
		splittedTextList = new ArrayList<>();
		for (String splitedText : splittedTexts) {
			String trimedText = splitedText.trim();
			validateText(trimedText);
			splittedTextList.add(trimedText);
		}
	}

	private void validateText(String trimedText) {
		if (!Validator.isUnder5Character(trimedText)) {
			System.out.println(RacingMessage.VALID_NAME_LENGTH);
			validated = false;
		}
		if (!Validator.isNotEmpty(trimedText)) {
			System.out.println(RacingMessage.VALID_NOT_EMPTY);
			validated = false;
		}
	}

	public List<String> getSplittedTextList() {
		return splittedTextList;
	}

	public boolean isValidated() {
		return validated;
	}
}
