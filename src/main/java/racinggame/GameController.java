package racinggame;

import racinggame.common.CommonCode;

public class GameController {
	private RacingCars racingCars;
	private MoveCount moveCount;

	public String[] printEnterCarNames() {
		return Printer.enterCarNames();
	}

	public boolean createCars(String[] carNames) {
		try {
			this.racingCars = RacingCars.createCars(carNames);
		} catch (IllegalArgumentException exception) {
			Printer.printMessage(exception.getMessage());
			return true;
		}
		return false;
	}

	public boolean printEnterMoveCount() {
		try {
			this.moveCount = MoveCount.get(Printer.enterMoveCount());
		} catch (IllegalArgumentException exception) {
			Printer.printMessage(exception.getMessage());
			return true;
		}
		return false;
	}

	public void startRacing() {
		Printer.printRacingRecordHeader();
		while (isRacingContinue(moveCount.value())) {
			racingCars.race();
			Printer.printRacingRecord(racingCars.getDistanceStringValues());
			moveCount.decrease();
		}
	}

	private boolean isRacingContinue(int moveCount) {
		if (moveCount > CommonCode.ZERO) {
			return true;
		}
		return false;
	}

	public void printRacingGameWinners() {
		Printer.printRacingGameWinners(racingCars.getWinnerNames());
	}
}
