package racinggame.controller;

import java.util.Set;
import java.util.HashSet;

public class InputValidator {
	private InputValidator() {}

	public static boolean validatePipeline(String input) {
		try{
			isEmptyInput(input);
			isNumberOfCarNames(input);
			isEmptyCarName(input);
			isNonDuplicate(input);
			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

		return false;
	}

	public static void isEmptyInput(String input) {
		if (input.isEmpty()) {
			throw new IllegalArgumentException("[ERROR] : 이름에 빈 문자열이 포합되어 있습니다. 다시 입력해주세요: ");
		}
	}

	public static void isEmptyCarName(String input) {
		String[] carNames = input.split(",");
		for (String carName : carNames) {
			isEmptyInput(carName);
		}
	}

	public static void isNumberOfCarNames(String input) {
		String replaced = input.replaceAll(",", "");
		int numOfCarNames = input.length() - replaced.length() + 1;

		String[] carNames = input.split(",");
		if (carNames.length < numOfCarNames) {
			throw new IllegalArgumentException("[ERROR] : 자동자 이름의 갯수가 이상합니다. 다시 입력해주세요: ");
		}
	}

	public static void isNonDuplicate(String input) {
		String[] cars = input.split(",");
		Set<String> carList = new HashSet<>();

		for (String carName : cars) {
			if (!carList.add(carName)) {
				throw new IllegalArgumentException("[ERROR] : 중복되는 문자열이 있습니다. 다시 입력해주세요: ");
			}
		}
	}
}
