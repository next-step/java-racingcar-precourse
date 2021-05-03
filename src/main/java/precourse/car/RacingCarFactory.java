package precourse.car;

import java.util.List;

public class RacingCarFactory {

	public static RacingCars createNewCars(RacingCarNameString racingCarNameString) {
		List<String> carNames = racingCarNameString.getCarNames();
		return new RacingCars(carNames);
	}

}
