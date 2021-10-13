package racinggame.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameRound {
	private static final Pattern pattern = Pattern.compile("^[0-9]+$");
	private int count;

	public GameRound(String inputString) {
		validate(inputString);
		this.count = convertInteger(inputString);
	}

	public boolean hasNext() {
		return reduceCount() > 0;
	}

	private int convertInteger(String inputString) {
		return Integer.parseInt(inputString);
	}

	private void validate(String inputString) {
		Matcher matcher = pattern.matcher(inputString);
		if (!matcher.find()) {
			throw new IllegalArgumentException("입력 값은 0 이상의 숫자여야 합니다.");
		}
	}

	private int reduceCount() {
		return count--;
	}
}
