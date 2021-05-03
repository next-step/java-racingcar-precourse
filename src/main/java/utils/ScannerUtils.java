package utils;

import java.util.Scanner;

public class ScannerUtils {

	public static String getRacingCarNameFromUser() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		Scanner sc = new Scanner(System.in);
		String userCarNames = sc.next();
		while (!isValidCarNameUserInput(userCarNames)) {
			System.out.println("입력이 바르지 않습니다. 다시 입력해주세요.");
			userCarNames = sc.next();
		}
		return userCarNames;
	}

	public static boolean isValidCarNameUserInput(String userCarNames) {
		String[] carNames = userCarNames.split(",");
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
		return carName != null && carName.trim().length() != 0;
	}

	public static int getPlayNumberFromUser() {
		System.out.println("시도할 회수는 몇회인가요?");
		Scanner sc = new Scanner(System.in);
		String playNumber = sc.next();
		while (!isValidPlayNumber(playNumber)) {
			System.out.println("시도할 회수를 다시 입력해주세요.");
			playNumber = sc.next();
		}
		return Integer.parseInt(playNumber);
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
