package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class RacingGame {
	private final String DETERMITER = ",";

	public void start(String racingCarNames, String gameCount) {
		List<String> carNames = separateCarName(racingCarNames);
		CarGroup racing = new CarGroup(carNames, gameCount);
		racing.start();

		printWinner(racing);
	}

	private void printWinner(CarGroup racing) {
		CarResult result = new CarResult();
		String winners = result.selectWinners(racing);
		if (winners.endsWith(",")) {
			winners = Optional.ofNullable(winners)
				.filter(s -> s.length() != 0)
				.map(s -> s.substring(0, s.length() - 1))
				.orElse(winners);
		}
		System.out.println();
		System.out.println(winners + "가 최종 우승했습니다.");
	}

	private List<String> separateCarName(String racingCarNames) {
		return Arrays.asList(racingCarNames.split(DETERMITER));
	}

}
