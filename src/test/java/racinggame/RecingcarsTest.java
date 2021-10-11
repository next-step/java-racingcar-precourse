package racinggame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RecingcarsTest {
	@Test
	void 레이싱_참가_자동차_개수_Test() {
		RacingCars racingCars = new RacingCars("pobi", "crong", "honux");
		assertThat(racingCars.validationRacingCarNumber()).isTrue();

		racingCars = new RacingCars("pobi", "crong", "honux", "pobi", "crong", "honux");
		assertThat(racingCars.validationRacingCarNumber()).isFalse();
	}
}
