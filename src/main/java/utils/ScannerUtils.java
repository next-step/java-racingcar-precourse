package utils;

import java.util.Scanner;

public class ScannerUtils {

	public static String getRacingCarNameFromUser() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		Scanner sc = new Scanner(System.in);
		String userCarNames = sc.next();
		while (!Validator.isValidCarNameUserInput(userCarNames)) {
			System.out.println("입력이 바르지 않습니다. 다시 입력해주세요.");
			userCarNames = sc.next();
		}
		return userCarNames;
	}

	public static int getPlayNumberFromUser() {
		System.out.println("시도할 회수는 몇회인가요?");
		Scanner sc = new Scanner(System.in);
		String playNumber = sc.next();
		while (!Validator.isValidPlayNumber(playNumber)) {
			System.out.println("시도할 회수를 다시 입력해주세요.");
			playNumber = sc.next();
		}
		return Integer.parseInt(playNumber);
	}

}
