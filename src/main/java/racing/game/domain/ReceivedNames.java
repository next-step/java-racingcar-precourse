package racing.game.domain;

import java.util.ArrayList;
import java.util.List;

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
			System.out.println("자동차의 이름이 5자를 초과합니다.");
			validated = false;
		}
		if(!Validator.isNotEmpty(trimedText)){
			System.out.println(",와 ,사이에 공백이 들어갈 수 없습니다.");
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
