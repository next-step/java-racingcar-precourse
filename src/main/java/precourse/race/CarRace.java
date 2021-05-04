package precourse.race;

import precourse.car.RacingCars;
import precourse.utility.ConsoleUI;

public class CarRace {

	private final RacingCars racingCars;
	private final CarRaceAttemptNumber attemptNumber;

	public CarRace(RacingCars racingCars, CarRaceAttemptNumber attemptNumber) {
		this.racingCars = racingCars;
		this.attemptNumber = attemptNumber;
	}

	public CarRaceWinners start() {
		ConsoleUI.show(CarRaceMessage.BEGIN_PRINTING_RESULT);
		for (int i = 0; i < attemptNumber.getNumber(); i++) {
			CarRaceAttemptResult raceResult = racingCars.drive();
			ConsoleUI.show(raceResult.createResultMessage());
		}
		return racingCars.getCarRaceWinners();
	}

}
