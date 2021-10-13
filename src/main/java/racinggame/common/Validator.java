package racinggame.common;

import static racinggame.common.CommonConstants.*;
import static racinggame.common.ErrorMessage.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * 유효성 검사 유틸 클래스
 *
 * @author Lee JungHo <jparangdev@gmail.com>
 * @version 1.0
 * @since 1.0
 */
public class Validator {

	private static final String TRY_INPUT_PATTERN = "^[1-9]([0-9])*$";
	private static final String INPUT_CAR_NAME_PATTERN = "^[가-힣a-zA-Z0-9]{1,5}(?:,[가-힣a-zA-Z0-9]{1,5})*$";

	/**
	 * 입력된 자동차 이름들의 유효성 검사
	 *
	 * @throws IllegalArgumentException 잘못된 입력값의 예외
	 * @throws IllegalStateException    중복된 입력값의 예외
	 */
	public static void validInputCarNames(String input) {
		validCarNamesPattern(input);
		validCarNamesDuplicate(input);
	}

	/**
	 * 입력된 자동차 이름들의 공백 확인
	 * 자동차의 이름은 완성된 한글, 숫자, 알파벳만 가능하며 1자이상 5자 이하
	 * 다수의 이름일 경우 ,단위로 구분
	 *
	 * @throws IllegalArgumentException 잘못된 입력값의 예외
	 */
	public static void validCarNamesPattern(String input) {
		if (input == null || input.trim().isEmpty() || !Pattern.matches(INPUT_CAR_NAME_PATTERN, input)) {
			throw new IllegalArgumentException(ERROR_INPUT_CAR_NAMES);
		}
	}

	/**
	 * 입력된 자동차 이름들의 중복 검사
	 *
	 * @throws IllegalStateException 중복된 입력값의 예외
	 */
	public static void validCarNamesDuplicate(String input) {
		String[] carNames = input.split(DELIMITER);
		Set<String> set = new HashSet<>();
		Collections.addAll(set, carNames);
		if (set.size() != carNames.length) {
			throw new IllegalStateException(ERROR_DUP_CAR_NAMES);
		}
	}

	/**
	 * 시도 회수가 숫자인지 검사
	 *
	 * @throws IllegalArgumentException 잘못된 입력의 예외
	 */
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

	/**
	 * 자동차 이름은 1자 이상 5자 이하여야 함
	 *
	 * @throws IllegalArgumentException 잘못된 입력의 예외
	 */
	public static void validCarNameLength(String input) {
		if (input == null || input.trim().length() < NAME_MIN_LENGTH || input.trim().length() > NAME_MAX_LENGTH) {
			throw new IllegalArgumentException(ErrorMessage.ERROR_CAR_INPUT_NAME);
		}
	}
}
