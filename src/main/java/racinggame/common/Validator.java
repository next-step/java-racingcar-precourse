package racinggame.common;

import static racinggame.common.CommonConstants.*;
import static racinggame.common.ErrorMessage.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Validator {

	private static final String TRY_INPUT_PATTERN = "^[1-9]([0-9])*$";
	private static final String INPUT_CAR_NAME_PATTERN = "^[가-힣a-zA-Z0-9]{1,5}(?:,[가-힣a-zA-Z0-9]{1,5})*$";

	public static void validInputCarNames(String input) {
		validCarNamesPattern(input);
		validCarNamesDuplicate(input);
	}

	public static void validCarNamesPattern(String input) {
		if (input == null || input.trim().isEmpty() || !Pattern.matches(INPUT_CAR_NAME_PATTERN, input)) {
			throw new IllegalArgumentException(ERROR_INPUT_CAR_NAMES);
		}
	}

	public static void validCarNamesDuplicate(String input) {
		String[] carNames = input.split(DELIMITER);
		Set<String> set = new HashSet<>();
		Collections.addAll(set, carNames);
		if (set.size() != carNames.length) {
			throw new IllegalStateException(ERROR_DUP_CAR_NAMES);
		}
	}

	public static void validTryCount(String input) {
		if (!Pattern.matches(TRY_INPUT_PATTERN, input)) {
			throw new IllegalArgumentException(ERROR_TRY_COUNT);
		}
		try {
			Integer.valueOf(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ErrorMessage.ERROR_TRY_COUNT);
		}
	}

	public static void validCarNameLength(String input) {
		if (input == null || input.trim().length() < NAME_MIN_LENGTH || input.trim().length() > NAME_MAX_LENGTH) {
			throw new IllegalArgumentException(ErrorMessage.ERROR_CAR_INPUT_NAME);
		}
	}
}
