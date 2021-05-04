import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RacingCarTest {
	private RacingCar racingCar;

	@BeforeEach
	public void setUp() {
		racingCar = new RacingCar("K5");
	}

	@Test
	public void 전진_여부_검증() {
		assertThat(racingCar.isMoveNumber(0)).isFalse();
		assertThat(racingCar.isMoveNumber(4)).isTrue();
		assertThat(racingCar.isMoveNumber(9)).isTrue();
	}

	@Test
	public void 전진_테스트() {
		racingCar.getMoveCount().plus();
		assertThat(racingCar.getMoveCount().get()).isEqualTo(1);
		racingCar.getMoveCount().plus();
		assertThat(racingCar.getMoveCount().get()).isEqualTo(2);
	}
}
