package io;

import java.util.Scanner;

public class GameInput {
	static final Scanner sc = new Scanner(System.in);

	public String inputCarName() {
		return sc.nextLine();
	}

	public int inputTryCount() {
		return sc.nextInt();
	}
}
