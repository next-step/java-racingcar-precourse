package racinggame;

import java.util.ArrayList;
import java.util.List;

import nextstep.utils.Randoms;

public class RacingCars {
	private final List<RacingCar> racingCars = new ArrayList<>();

	public static RacingCars createCars(String[] carNames) {
		RacingCars racingCars = new RacingCars();
		for (String carName : carNames) {
			racingCars.add(RacingCar.createCar(carName));
		}
		return racingCars;
	}

	private void add(RacingCar racingCar) {
		racingCars.add(racingCar);
	}

	public void race() {
		for (RacingCar racingCar : racingCars) {
			racingCar.moveForwardOrStop(Randoms.pickNumberInRange(0, 9));
		}
	}

	public List<String> getDistanceStringValues() {
		List<String> distanceStringValues = new ArrayList<>();
		for (RacingCar racingCar : racingCars) {
			distanceStringValues.add(getDistanceStringValue(racingCar.getName(), racingCar.getDistanceStringValue()));
		}
		return distanceStringValues;
	}

	private String getDistanceStringValue(String carName, String distanceStringValue) {
		return carName + " : " + distanceStringValue;
	}

}
