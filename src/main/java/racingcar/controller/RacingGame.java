package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Race;

public class RacingGame {
	public void start() {
		Race race = new Race();
		race.inputCarNames();
		String tryCount = Console.readLine();
		race(race, tryCount);
		printResult(race);
	}

	private void printResult(Race race) {
		race.getWinner();
	}

	private void race(Race race, String tryCount) {
		int raceCount = Integer.parseInt(tryCount);
		for (int i = 0; i < raceCount; i++) {
			race.racing();
		}
	}
}
