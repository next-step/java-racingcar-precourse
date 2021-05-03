package racingcar;

import java.util.Scanner;

public class Utils {
	private static Scanner scanner = new Scanner(System.in);

	public static String getStringInput() {
		return scanner.nextLine().trim();
	}

	public static int getInteger() {
		return scanner.nextInt();
	}

	public static int getRandomNumberBetween0to9() {
		return (int)(Math.random() * 10);
	}

	public static String[] splitByComma(String input) {
		int commaNum = getCommaNum(input);
		if (input.split(",").length != commaNum + 1) {
			throw new IllegalArgumentException("빈 이름은 불가능합니다.");
		}

		return input.split(",");
	}

	private static int getCommaNum(String input) {
		char[] chars = input.toCharArray();
		int cnt = 0;
		for (char character : chars) {
			cnt += isComma(character);
		}
		return cnt;
	}

	private static int isComma(char character) {
		if (character== ',') {
			return 1;
		}
		return 0;
	}

}
