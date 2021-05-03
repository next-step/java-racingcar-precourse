package io.github.redlasha.racingcar;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

public class GameLauncher {

	private static final Scanner SCANNER = new Scanner(System.in);
	private static final PrintStream PRINT_STREAM = System.out;
	public static Supplier<String> userCommandSupplier = () -> {
		return SCANNER.nextLine();
	};

	public static void main(String[] args) {
		PRINT_STREAM.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
		CarEntries entries = createCarEntriesFromUserInput();
		PRINT_STREAM.println("시도할 회수는 몇회인가요?");
		RacingTurn turn = createRacingTurnFromUserInput();
		RacingGame game = new RacingGame(entries, turn, new RandomDice(), PRINT_STREAM);
		PRINT_STREAM.println("실행 결과");
		game.start();
		List<Car> winners = game.matchResult();
		printWinners(winners);
	}

	static void printWinners(List<Car> winners) {
		String winnersName = "";
		for (int i = 0; i < winners.size(); i++) {
			String comma = (i == (winners.size() - 1)) ? "" : ", ";
			winnersName += winners.get(i).getCarName() + comma;
		}
		PRINT_STREAM.println(winnersName + "가 최종 우승했습니다.");
	}

	static CarEntries createCarEntriesFromUserInput() {
		CarEntries entries = null;
		while (entries == null) {
			String cars = userCommandSupplier.get();
			entries = createCarEntries(cars);
		}
		return entries;
	}

	static CarEntries createCarEntries(String cars) {
		try {
			return new CarEntries(cars);
		} catch (Throwable e) {
			PRINT_STREAM.println("경주할 자동차 이름을 다시 입력해주세요. (이름은 쉼표(,) 기준으로 구분)");
			return null;
		}
	}

	static RacingTurn createRacingTurnFromUserInput() {
		RacingTurn turn = null;
		while (turn == null) {
			String turnInput = userCommandSupplier.get();
			turn = createRacingTurn(turnInput);
		}
		return turn;
	}

	static RacingTurn createRacingTurn(String input) {
		try {
			return new RacingTurn(Integer.valueOf(input));
		} catch (Throwable e) {
			PRINT_STREAM.println("다시 입력해주세요. 시도할 회수는 몇회인가요?");
			return null;
		}
	}
}
