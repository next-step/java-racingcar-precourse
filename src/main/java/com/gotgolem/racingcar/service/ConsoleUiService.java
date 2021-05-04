package com.gotgolem.racingcar.service;

import java.util.Scanner;

public class ConsoleUiService {

	private final Scanner scanner;

	public ConsoleUiService() {
		scanner = new Scanner(System.in);
	}

	public String requestCarNames() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		return scanner.nextLine();
	}

	public int requestMatchCount() {
		System.out.println("시도할 회수는 몇회인가요?");
		return scanner.nextInt();
	}
}
