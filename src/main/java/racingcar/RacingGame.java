package racingcar;

import java.util.Arrays;
import java.util.List;

public class RacingGame {
	private final String DETERMITER = ",";

	public void start(String racingCarNames, String gameCount) {
		List<String> carNames = separateCarName(racingCarNames);
		CarGroup racing = new CarGroup(carNames, gameCount);
		racing.start();
	}

	private List<String> separateCarName(String racingCarNames) {
		return Arrays.asList(racingCarNames.split(DETERMITER));
	}

}
