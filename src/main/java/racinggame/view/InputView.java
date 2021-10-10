package racinggame.view;

import nextstep.utils.Console;
import racinggame.ValidationUtils;

import java.util.Arrays;
import java.util.List;

public class InputView {

	private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String INPUT_ROUND_MESSAGE = "시도할 회수는 몇회인가요?";
	private static final String INVALID_NUMBER_MESSAGE = "[ERROR]시도할 회수는 숫자로 입력해주세요.";
	private static final String INVALID_ZERO_MESSAGE = "[ERROR]시도할 회수는 1 이상 입력해주세요.";
	private static final String INVALID_CAR_DIFFERENT_NAME_MESSAGE = "[ERROR]서로 다른 자동차 이름을 입력해주세요.";
	private static final String INVALID_CAR_NAME_LENGTH_MESSAGE = "[ERROR]자동차 이름은 5글자 이하로 입력해주세요.";
	private static final String INVALID_CAR_MINIMUM_SIZE_MESSAGE = "[ERROR]자동차는 이름을 2개 이상 입력해주세요";
	public static final String NAME_DELIMITER = ",";

	public List<String> inputCarNames() {
		try {
			System.out.println(INPUT_CAR_NAMES_MESSAGE);
			String text = Console.readLine();
			validationCarNames(text);
			return Arrays.asList(text.split(NAME_DELIMITER));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return inputCarNames();
		}
	}

	public int inputRound() {
		try {
			System.out.println(INPUT_ROUND_MESSAGE);
			String round = Console.readLine();
			validationRound(round);
			return Integer.parseInt(round);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return inputRound();
		}
	}

	private void validationRound(String round) {
		if (!ValidationUtils.validNumber(round)) {
			throw new IllegalArgumentException(INVALID_NUMBER_MESSAGE);
		}

		if (!ValidationUtils.validZeroMore(round)) {
			throw new IllegalArgumentException(INVALID_ZERO_MESSAGE);
		}
	}

	private void validationCarNames(String text) {
		if (!ValidationUtils.validName(text)) {
			throw new IllegalArgumentException(INVALID_CAR_DIFFERENT_NAME_MESSAGE);
		}

		if (!ValidationUtils.validTwoMore(text)) {
			throw new IllegalArgumentException(INVALID_CAR_MINIMUM_SIZE_MESSAGE);
		}

		validationNames(Arrays.asList(text.split(NAME_DELIMITER)));
	}

	private void validationNames(List<String> names) {
		for (String name : names) {
			validationName(name);
		}
	}

	private void validationName(String name) {
		if (!ValidationUtils.validNameLength(name)) {
			throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH_MESSAGE);
		}
	}
}
