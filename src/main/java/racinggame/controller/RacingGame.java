package racinggame.controller;

import java.util.ArrayList;
import java.util.List;

import racinggame.domain.CarStatus;
import racinggame.domain.Cars;
import racinggame.domain.MoveCount;
import racinggame.view.User;

public class RacingGame {
	public static final String RESULT_MESSAGE = "실행 결과";
	public static final String WINNER_MESSAGE_LEFT = "최종 우승자는 ";
	public static final String WINNER_MESSAGE_RIGHT = " 입니다.";
	public static final String EACH_RESULT_NEWLINE = "";
	public static final String WINNER_DELIMITER = ",";
	public static final String CARNAME_HYPHEN_BETWEEN_DELIMITER = " : ";
	public static final String APPEND_GO = "-";

	private Cars cars;
	private MoveCount moveCount;
	private int tryCount;
	private boolean isReady;
	private List<StringBuilder> result = new ArrayList<>();
	private StringBuilder winner = new StringBuilder();

	public RacingGame(User user) {
		try {
			checkExistCars(user);
			this.moveCount = new MoveCount(user.getReadLineMoveCount());
			this.tryCount = 0;
			this.isReady = true;
		} catch (IllegalArgumentException ex) {
			isReady = false;
			System.out.println(ex.getMessage());
		}
	}

	private void checkExistCars(User user) {
		if (!user.isValidatedCarName()) {
			this.cars = new Cars(user.getReadLineCarNames());
			user.validatedCarName();
			return;
		}
		this.cars = new Cars(user.getCarNames());
	}

	public void play() {
		makeResultBuilder();
		while (!isEnd()) {
			makeResult();
			tryCount++;
			printResultNewLine();
		}
		makeWinner();
	}

	private void printResultNewLine() {
		System.out.println(EACH_RESULT_NEWLINE);
	}

	private void makeResultBuilder() {
		for (int i = 0; i < cars.getSize(); i++) {
			result.add(i, new StringBuilder());
		}
		System.out.println(RESULT_MESSAGE);
	}

	private void makeWinner() {
		int max = 0;
		for (int i = 0; i < cars.getSize(); i++) {
			max = Math.max(result.get(i).length(), max);
		}
		for (int k = 0; k < cars.getSize(); k++) {
			appendWinner(max, winner, k);
		}
		System.out.println(WINNER_MESSAGE_LEFT + winner + WINNER_MESSAGE_RIGHT);
	}

	private void appendWinner(int max, StringBuilder winner, int index) {
		if (max == result.get(index).length()) {
			appendRest(winner);
			winner.append(cars.getCarName(index));
		}
	}

	private void appendRest(StringBuilder winner) {
		if (!"".equals(winner.toString())) {
			winner.append(WINNER_DELIMITER);
		}
	}

	private void makeResult() {
		for (int k = 0; k < cars.getSize(); k++) {
			StringBuilder printAppender = result.get(k);
			CarStatus carStatus = cars.move(k);
			appendGo(printAppender, carStatus);
			System.out.println(cars.getCarName(k) + CARNAME_HYPHEN_BETWEEN_DELIMITER + printAppender);
		}
	}

	private void appendGo(StringBuilder result, CarStatus carStatus) {
		if (carStatus.isGo()) {
			result.append(APPEND_GO);
		}
	}

	private boolean isEnd() {
		return moveCount.isEnd(tryCount);
	}

	public boolean isReady() {
		return isReady;
	}

}
