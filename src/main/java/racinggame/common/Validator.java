package racinggame.common;

import static racinggame.common.CommonConstants.*;
import static racinggame.common.ErrorMessage.*;

import java.util.regex.Pattern;

public class Validator {

	private static final String TRY_INPUT_PATTERN = "^[1-9]([0-9]+)$";

	public static void validInputEmpty(String input) {
		if (input == null || input.isEmpty() || "".equals(input.trim())) {
			throw new IllegalArgumentException(ERROR_INPUT_NAME);
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

	public static void validCarName(String input) {
		if(input == null || input.trim().length() < NAME_MIN_LENGTH || input.trim().length() > NAME_MAX_LENGTH) {
			throw new IllegalArgumentException(ErrorMessage.ERROR_CAR_INPUT_NAME);
		}
	}
}
