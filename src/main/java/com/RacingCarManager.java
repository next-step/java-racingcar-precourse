package com;

import java.util.Scanner;

import com.racingcar.RacingCars;

public class RacingCarManager {
	private static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String REPEAT_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
	private static final String FINAL_RESULT_MESSAGE = "가 최종 우승했습니다.";

	public static void main(String[] args) {

		System.out.println(START_MESSAGE);

		try (Scanner sc = new Scanner(System.in)) {
			RacingCars racingCars = RacingCars.of(sc.nextLine());

			System.out.println(REPEAT_COUNT_MESSAGE);
			start(racingCars, sc.nextInt());

			System.out.println(RacingCars.winnerNamesIn(racingCars) + FINAL_RESULT_MESSAGE);
		}
	}

	public static void start(RacingCars racingCars, int repeatCount) {
		for (int i = 0; i < repeatCount; i++) {
			racingCars.startByCar();
			racingCars.printNameAndLocationByCar();

			printSpace();
		}
	}

	private static void printSpace() {
		System.out.println("\n");
	}
}
