package racingcar;

import java.util.Scanner;

public class Utils {
	private static Scanner scanner;

	public static String getStringInput(){
		return scanner.nextLine().trim();
	}

	public static int getRandomNumberBetween0to9(){
		return (int)(Math.random() * 10);
	}
}
