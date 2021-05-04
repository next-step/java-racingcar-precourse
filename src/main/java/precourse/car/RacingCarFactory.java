package precourse.car;

import java.util.List;

public class RacingCarFactory {

	public static RacingCars createNewCars(RacingCarNameSequence racingCarNameSequence) {
		List<String> carNames = racingCarNameSequence.getCarNames();
		return new RacingCars(carNames);
	}

}
