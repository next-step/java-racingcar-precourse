package utils;

public class Validator {

	public static boolean isValidCarNameUserInput(String userCarNames) {
		String[] carNames = userCarNames.split(",");
		if (userCarNames.startsWith(",") || userCarNames.endsWith(",")) {
			return false;
		}

		int carNumber = carNames.length;
		if (carNumber == 0) {
			return false;
		}

		for (String carName : carNames) {
			if (!isValidCarName(carName)) {
				return false;
			}
		}

		return true;
	}

	public static boolean isValidCarName(String carName) {
		return carName != null && carName.trim().length() > 0 && carName.trim().length() <= 5;
	}

	public static boolean isValidPlayNumber(String userInput) {
		int playNumber;

		try {
			playNumber = Integer.parseInt(userInput);
		} catch (NumberFormatException e) {
			System.out.println("숫자만 입력 가능합니다.");
			return false;
		}

		if (playNumber <= 0) {
			System.out.println("회수는 0 이상이어야 합니다.");
			return false;
		}

		return true;
	}
}
