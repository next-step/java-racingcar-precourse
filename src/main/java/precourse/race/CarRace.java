package precourse.race;

import precourse.car.RacingCars;
import precourse.utility.ConsoleUI;

public class CarRace {

	private final RacingCars racingCars;
	private final CarRaceTryNumber tryNumber;

	public CarRace(RacingCars racingCars, CarRaceTryNumber tryNumber) {
		this.racingCars = racingCars;
		this.tryNumber = tryNumber;
	}

	public CarRaceWinners start() {
		ConsoleUI.show(CarRaceMessage.BEGIN_PRINTING_RESULT);
		for (int i = 0; i < tryNumber.getNumber(); i++) {
			CarRaceTryResult raceResult = racingCars.drive();
			ConsoleUI.show(raceResult.createResultMessage());
		}
		return racingCars.getCarRaceWinners();
	}

}
