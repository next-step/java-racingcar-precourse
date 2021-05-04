package precourse.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import precourse.race.CarRaceAttemptResult;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsTest {

	@Test
	@DisplayName("자동차 경주를 시도할 때 자동차들의 이동 상황을 출력한다.")
	void showCarRaceAttemptProcess() {
		RacingCars racingCars = new RacingCars(Arrays.asList("pobi", "crong", "honux"));
		CarRaceAttemptResult attemptResult = racingCars.drive();
		assertThat(attemptResult.createResultMessage())
				.contains("pobi\t:").contains("crong\t:").contains("honux\t:");
	}

}
