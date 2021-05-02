package utils;

import java.util.Scanner;

public class ScannerUtils {

	public static String getRacingCarNameFromUser() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		Scanner sc = new Scanner(System.in);
		String userCarNames = sc.next();
		while (!isValidCarNames(userCarNames)) {
			System.out.println("입력이 바르지 않습니다. 다시 입력해주세요.");
			userCarNames = sc.next();
		}
		return userCarNames;
	}

	public static boolean isValidCarNames(String userCarNames) {
		String[] carNames = userCarNames.split(",");
		int carNumber = carNames.length;
		if (carNumber == 0) {
			return false;
		}

		for (String carName : carNames) {
			if (carName == null || carName.trim().length() == 0) {
				return false;
			}
		}

		return true;
	}
}
