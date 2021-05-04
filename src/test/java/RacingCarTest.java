import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.RacingCar;
import domain.RacingCars;

public class RacingCarTest {
	private RacingCar racingCar;
	private RacingCars racingCars;

	@BeforeEach
	public void setUp() {
		racingCar = new RacingCar("K5");
		racingCars = new RacingCars(new String[] {"K5", "마티즈"});
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

	@Test
	public void 최대_거리_측정_테스트() {
		RacingCar firstCar = racingCars.get().get(0);
		RacingCar secondCar = racingCars.get().get(1);
		firstCar.getMoveCount().plus();
		assertThat(racingCars.maxCount()).isEqualTo(1);
		plusRacingCar(secondCar, 2);
		assertThat(racingCars.maxCount()).isEqualTo(2);
		plusRacingCar(firstCar, 2);
		assertThat(racingCars.maxCount()).isEqualTo(3);
	}

	private void plusRacingCar(RacingCar racingCar, int plusCount) {
		for (int i = 0; i < plusCount; i++) {
			racingCar.getMoveCount().plus();
		}
	}
}
