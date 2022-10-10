package racingcar;

import static camp.nextstep.edu.missionutils.Console.*;

public class Game {
	private Players players;
	private int lab;

	public Game() {
	}

	public void play() {
		printCarNameMessage();
		initGame(readLine());
		printLabCountMessage();
		insertLab(readLine());
		runCar();
		gameResult();
	}

	private void gameResult() {
		String winner = this.players.getWinner();
		System.out.println("최종 우승자 : " + winner);
	}

	private void runCar() {
		for (int i = 0; i < this.lab; i++) {
			this.players.run();
			printStatusMessage();
			System.out.println();
		}
	}

	private void printStatusMessage() {
		System.out.println(this.players.status());
	}

	private void printCarNameMessage() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
	}

	private void printLabCountMessage() {
		System.out.println("시도할 회수는 몇회인가요?\n");
	}

	private void initGame(String userNames) {
		try {
			this.players = new Players(userNames);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			this.initGame(readLine());
		}

	}

	private void insertLab(String lab) {
		try {
			this.lab = Integer.parseInt(lab);
		} catch (NumberFormatException e) {
			printFormatExceptionMessage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void printFormatExceptionMessage() {
		System.out.printf("정수만 입력할 수 있습니다.%n");
	}
}
