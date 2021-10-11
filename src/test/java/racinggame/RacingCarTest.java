package racinggame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RacingCarTest {
	@Test
	void 자동자_이름_길이_확인_Test() {
		RacingCar recingcar = new RacingCar("pobi");
		assertThat(recingcar.checkCarNameLength()).isTrue();

		recingcar = new RacingCar("pobicrong");
		assertThat(recingcar.checkCarNameLength()).isFalse();

		recingcar = new RacingCar("");
		assertThat(recingcar.checkCarNameLength()).isFalse();
	}
}
