package racinggame.domain;

import nextstep.utils.Randoms;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class CarTest {
	@Test
	void move1Test() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
					.thenReturn(4);
			Car car = new Car(Name.of("Tico"));
			car.move();
			assertThat(car.getDistance())
					.isEqualTo(Distance.of(1));
		}
	}

	@Test
	void move0Test() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
					.thenReturn(3);
			Car car = new Car(Name.of("Tico"));
			car.move();
			assertThat(car.getDistance())
					.isEqualTo(Distance.of(0));
		}
	}
}
