package racinggame;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import nextstep.utils.Randoms;

public class RacingCarTest {
	@Test
	void 전진_정지_테스트() {
		RacingCar car = new RacingCar("pobi");
		Position position;

		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(4, 3, 0, 9);

			position = car.move();
			position = car.move();
			position = car.move();
			position = car.move();

			assertThat(position.getX()).isEqualTo(2);
		}
	}

	@Test
	void 전진_정지_여러번_테스트() {
		RacingCar car = new RacingCar("pobi");
		Position position;

		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(4, 3, 0, 9);

			position = car.moves(4);

			assertThat(position.getX()).isEqualTo(2);
		}
	}
}
