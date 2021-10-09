package racinggame.domain;

import nextstep.utils.Randoms;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class CarsTest {
	@Test
	void moveTest() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
					.thenReturn(4, 3, 4);
			Cars cars = new Cars(Arrays.asList(new Car(Name.of("pobi")), new Car(Name.of("crong")), new Car(Name.of("honux"))));
			cars.move();
			assertThat(cars.get(0).getDistance())
					.isEqualTo(Distance.of(1));
			assertThat(cars.get(1).getDistance())
					.isEqualTo(Distance.of(0));
			assertThat(cars.get(2).getDistance())
					.isEqualTo(Distance.of(1));
		}
	}

	@Test
	void checkCarsSizeTest() {
		assertThatThrownBy(() -> new Cars(new ArrayList<>()))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void checkSameNameTest() {
		assertThatThrownBy(() -> new Cars(Arrays.asList(new Car(Name.of("pobi")), new Car(Name.of("crong")), new Car(Name.of("pobi")))))
				.isInstanceOf(IllegalArgumentException.class);
	}
}
