package com.gotgolem.racingcar.service;

import java.util.Arrays;
import java.util.Scanner;

import com.gotgolem.racingcar.asset.Car;
import com.gotgolem.racingcar.asset.Cars;

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

	public void printMatchResult(Cars cars) {
		for (int i = 0; i < cars.size(); i++) {
			final Car car = cars.getCar(i);
			final char[] chars = new char[car.getMileage()];
			Arrays.fill(chars, '-');
			System.out.printf("%s : %s\n", car.getName(), String.valueOf(chars));
		}
		System.out.println();
	}

	public void printWinners(Cars cars) {
		final String[] winners = new String[cars.size()];
		for (int i = 0; i < cars.size(); i++) {
			winners[i] = cars.getCar(i).getName();
		}
		System.out.printf("%s가 최종 우승했습니다.\n", String.join(", ", winners));
	}

}
