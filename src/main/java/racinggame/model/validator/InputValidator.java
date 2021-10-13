package racinggame.model.validator;

import java.util.Set;
import java.util.HashSet;

public class InputValidator {
	private InputValidator() {}

	public static boolean validatePipeline(String input) {
		try{
			String[] inputs = input.split(",");
			isEmptyInput(input);
			isNumberOfCarNames(input);
			isEmptyCarName(inputs);
			isNonDuplicate(inputs);
			isRightNameLength(inputs);

			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

		return false;
	}

	public static void isEmptyInput(String input) {
		if (input.isEmpty()) {
			throw new IllegalArgumentException("[ERROR] : 이름에 빈 문자열이 포합되어 있습니다.");
		}
	}

	public static void isEmptyCarName(String[] carNames) {
		for (String carName : carNames) {
			isEmptyInput(carName);
		}
	}

	public static void isNumberOfCarNames(String input) {
		String replaced = input.replaceAll(",", "");
		int numOfCarNames = input.length() - replaced.length() + 1;

		String[] carNames = input.split(",");
		if (carNames.length < numOfCarNames) {
			throw new IllegalArgumentException("[ERROR] : 자동자 이름의 갯수가 이상합니다.");
		}
	}

	public static void isNonDuplicate(String[] cars) {
		Set<String> carList = new HashSet<>();

		for (String carName : cars) {
			if (!carList.add(carName)) {
				throw new IllegalArgumentException("[ERROR] : 중복되는 문자열이 있습니다.");
			}
		}
	}

	public static void isRightNameLength(String[] carNames){
		for (String carName : carNames) {
			int carNameLength = carName.length();
			if (carNameLength < 1 || carNameLength >= 6) {
				throw new IllegalArgumentException("[ERROR] : 자동차 이름의 길이가 알맞지 않습니다.");
			}
		}
	}
}
