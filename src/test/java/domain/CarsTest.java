package domain;

import nextstep.utils.Randoms;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class CarsTest {
	public static final int MOVING_FORWARD = 4;
	public static final int STOP = 3;

	@Test
	void 일괄이동() {
		Cars cars = new Cars(
				Arrays.asList(
						new Car("pobi"),
						new Car("crong"),
						new Car("honux")));

		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
					.thenReturn(MOVING_FORWARD, STOP, MOVING_FORWARD);
			cars.move();
			assertThat(cars.get(0).getDistance()).isEqualTo(1);
			assertThat(cars.get(1).getDistance()).isEqualTo(0);
			assertThat(cars.get(2).getDistance()).isEqualTo(1);
		}
	}
}
