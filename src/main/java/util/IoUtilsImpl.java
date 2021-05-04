package util;

import java.util.Scanner;

public class IoUtilsImpl implements IoUtils {
	Scanner scanner = new Scanner(System.in);

	@Override
	public String input() {
		return scanner.nextLine();
	}

	@Override
	public void output(String text) {
		System.out.println(text);
	}
}
