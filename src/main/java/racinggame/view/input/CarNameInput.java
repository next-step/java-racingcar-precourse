package racinggame.view.input;

import static nextstep.utils.Constants.*;

import java.util.Arrays;
import java.util.List;

public class CarNameInput {
	private static final String INVALID_CAR_NAME_LENGTH_ERROR_MASSAGE = "[ERROR] 자동차 이름은 5글자를 넘길 수 없습니다.";

	private final List<String> names;

	public CarNameInput(final String line) {
		this.names = validationAndConvertNames(line.split(DELIMITER_COMMA));
	}

	public List<String> getCarNames() {
		return names;
	}

	private List<String> validationAndConvertNames(final String[] input) {
		for (String name : input) {
			validation(name);
		}
		return Arrays.asList(input);
	}

	private static void validation(final String name) {
		if (name.length() > 5) {
			throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH_ERROR_MASSAGE);
		}
	}
}
