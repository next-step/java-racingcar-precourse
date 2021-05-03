import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import org.junit.jupiter.api.Test;

public class RacingCarTest {
	@Test
	public void 전진_여부_검증() {
		RacingCar racingCar = new RacingCar("K5");
		assertThat(racingCar.isMoveNumber(0)).isFalse();
		assertThat(racingCar.isMoveNumber(4)).isTrue();
		assertThat(racingCar.isMoveNumber(9)).isTrue();
	}
}
