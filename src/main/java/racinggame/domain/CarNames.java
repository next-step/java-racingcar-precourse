package racinggame.domain;

import static racinggame.common.CommonConstants.*;
import static racinggame.common.ErrorMessage.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class CarNames {

	private static final String INPUT_CAR_NAME_PATTERN = "^[가-힣a-zA-Z0-9]{1,5}(?:,[가-힣a-zA-Z0-9]{1,5})*$";

	String carNames;

	public CarNames(String carNames) {
		validCarNamesPattern(carNames);
		validCarNamesDuplicate(carNames);
		this.carNames = carNames;
	}

	public String getCarNames() {
		return carNames;
	}

	public List<String> getCarNameList() {
		String[] carNameArr = carNames.split(DELIMITER);
		return Arrays.asList(carNameArr);
	}

	/**
	 * 입력된 자동차 이름들의 공백 확인
	 * 자동차의 이름은 완성된 한글, 숫자, 알파벳만 가능하며 1자이상 5자 이하
	 * 다수의 이름일 경우 ,단위로 구분
	 *
	 * @throws IllegalArgumentException 잘못된 입력값의 예외
	 */
	private void validCarNamesPattern(String input) {
		if (input == null || input.trim().isEmpty() || !Pattern.matches(INPUT_CAR_NAME_PATTERN, input)) {
			throw new IllegalArgumentException(ERROR_INPUT_CAR_NAMES);
		}
	}

	/**
	 * 입력된 자동차 이름들의 중복 검사
	 *
	 * @throws IllegalStateException 중복된 입력값의 예외
	 */
	private void validCarNamesDuplicate(String input) {
		String[] carNames = input.split(DELIMITER);
		Set<String> set = new HashSet<>();
		Collections.addAll(set, carNames);
		if (set.size() != carNames.length) {
			throw new IllegalArgumentException(ERROR_DUP_CAR_NAMES);
		}
	}

}
