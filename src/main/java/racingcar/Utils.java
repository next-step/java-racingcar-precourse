package racingcar;

import java.util.Scanner;

public class Utils {
	private static Scanner scanner = new Scanner(System.in);

	public static String getStringInput(){
		return scanner.nextLine().trim();
	}

	public static int getInteger(){
		return scanner.nextInt();
	}

	public static int getRandomNumberBetween0to9(){
		return (int)(Math.random() * 10);
	}

	public static String[] splitByComma(String input) {
		return input.split(",");
	}
}
