package precourse.car;

import java.util.ArrayList;
import java.util.List;

import precourse.race.CarRaceTryResult;
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

	private List<RacingCar> createNewCars(List<String> carNames) {
		List<RacingCar> racingCars = new ArrayList<>();
		for (String carName : carNames) {
			RacingCarName racingCarName = new RacingCarName(carName);
			racingCars.add(new RacingCar(racingCarName));
		}
		return racingCars;
	}

}
