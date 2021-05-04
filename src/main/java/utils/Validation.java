package utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Validation {
	public static final int MAX_CARNAME_LENGTH = 5;
	public static final int MIN_CARNAME_LENGTH = 0;
	public static final int MIN_CAR_COUNT = 1;
	public static final int MIN_ROUND_COUNT = 0;

	public static boolean validateCarName(String[] splittedCarNames) {
		for (String carName : splittedCarNames) {
			if (!isValidCarNameLength(carName)) {
				System.out.println("경주할 자동차 이름은 최소 1자 이상 5자 이하여야 합니다.");
				return false;
			}
		}
		if (!isValidCarCounts(splittedCarNames)) {
			System.out.println("자동차 이름이 2개 이상이어야 합니다.");
			return false;
		}
		if (isDuplicateCarNameExists(splittedCarNames)) {
			System.out.println("중복된 자동차 이름이 존재합니다.");
			return false;
		}
		return true;
	}

	public static boolean isValidCarNameLength(String carName) {
		return carName.length() > MIN_CARNAME_LENGTH && carName.length() <= MAX_CARNAME_LENGTH;
	}

	public static boolean isValidCarCounts(String[] splittedCarNames) {
		return splittedCarNames.length > MIN_CAR_COUNT;
	}

	public static boolean isDuplicateCarNameExists(String[] splittedCarNamesList) {
		Set<String> splittedCarNamesSet = new HashSet<>(Arrays.asList(splittedCarNamesList));
		return splittedCarNamesList.length != splittedCarNamesSet.size();
	}

	public static boolean validateRoundCount(String roundCount) {
		if (!isValidInteger(roundCount)) {
			System.out.println("자연수가 아닙니다.");
			return false;
		}

		if (!isValidCountRange(Integer.parseInt(roundCount))) {
			System.out.println("자연수가 아닙니다.");
			return false;
		}
		return true;
	}

	public static boolean isValidInteger(String inputRoundCount) {
		try {
			Integer.parseInt(inputRoundCount);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	public static boolean isValidCountRange(int roundCount) {
		return roundCount > MIN_ROUND_COUNT;
	}
}
