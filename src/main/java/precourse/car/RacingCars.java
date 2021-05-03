package precourse.car;

import java.util.ArrayList;
import java.util.List;

import precourse.race.CarRaceTryResult;
import precourse.race.CarRaceWinners;
import precourse.utility.MovementNumber;
import precourse.utility.MovementNumberGenerator;

public class RacingCars {

	private final List<RacingCar> racingCars;

	public RacingCars(List<String> carNames) {
		this.racingCars = createNewCars(carNames);
	}

	public CarRaceTryResult drive() {
		for (RacingCar racingCar : racingCars) {
			MovementNumber number = MovementNumberGenerator.createMovementNumber();
			racingCar.decideMovement(number);
		}
		return new CarRaceTryResult(racingCars);
	}

	public CarRaceWinners getCarRaceWinners() {
		int maxPosition = getMaxPosition();
		List<RacingCar> winners = new ArrayList<>();
		for (RacingCar racingCar : racingCars) {
			addCarRaceWinners(racingCar, maxPosition, winners);
		}
		return new CarRaceWinners(winners);
	}

	private void addCarRaceWinners(RacingCar racingCar, int maxPosition, List<RacingCar> winners) {
		if (racingCar.isWinner(maxPosition)) {
			winners.add(racingCar);
		}
	}

	private List<RacingCar> createNewCars(List<String> carNames) {
		List<RacingCar> racingCars = new ArrayList<>();
		for (String carName : carNames) {
			RacingCarName racingCarName = new RacingCarName(carName);
			racingCars.add(new RacingCar(racingCarName));
		}
		return racingCars;
	}

	private int getMaxPosition() {
		int maxPosition = 0;
		for (RacingCar racingCar : racingCars) {
			maxPosition = Math.max(racingCar.getPosition(), maxPosition);
		}
		return maxPosition;
	}

}
