package racinggame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import nextstep.utils.Randoms;
import racinggame.common.CommonCode;

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
			racingCar.moveForwardOrStop(Randoms.pickNumberInRange(CommonCode.ZERO, CommonCode.NINE));
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
		return carName + CommonCode.COLON + distanceStringValue;
	}

	public List<String> getWinnerNames() {
		Collections.sort(racingCars, (r1, r2) -> r2.getDistanceNumberValue() - r1.getDistanceNumberValue());
		List<String> winnerNames = new ArrayList<>();
		for (RacingCar racingCar : racingCars) {
			ifWinnerAddList(winnerNames, racingCar);
		}
		return winnerNames;
	}

	private void ifWinnerAddList(List<String> winnerNames, RacingCar racingCar) {
		if (racingCars.get(CommonCode.ZERO).getDistanceNumberValue() == racingCar.getDistanceNumberValue()) {
			winnerNames.add(racingCar.getName());
		}
	}
}
