package precourse.car;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import precourse.race.CarRaceTryResult;

public class RacingCarsTest {

	@Test
	@DisplayName("자동차 경주를 시도할 때 자동차들의 이동 상황을 출력한다.")
	void showCarRaceTryProcess() {
		RacingCars racingCars = new RacingCars(Arrays.asList("pobi", "crong", "honux"));
		CarRaceTryResult tryResult = racingCars.drive();
		assertThat(tryResult.createResultMessage()).contains("pobi\t:").contains("crong\t:").contains("honux\t:");
	}

}
