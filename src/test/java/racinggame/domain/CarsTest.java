package racinggame.domain;

import nextstep.utils.Randoms;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

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
			Car pobi = new Car(Name.of("pobi"));
			Car crong = new Car(Name.of("crong"));
			Car honux = new Car(Name.of("honux"));
			Cars cars = new Cars(Arrays.asList(pobi, crong, honux));
			cars.move();
			Iterator<Car> itr = cars.iterator();
			assertThat(itr.hasNext())
					.isTrue();
			assertThat(itr.next())
					.isEqualTo(pobi)
					.extracting(Car::getDistance)
					.isEqualTo(Distance.of(1));
			assertThat(itr.hasNext())
					.isTrue();
			assertThat(itr.next())
					.isEqualTo(crong)
					.extracting(Car::getDistance)
					.isEqualTo(Distance.of(0));
			assertThat(itr.hasNext())
					.isTrue();
			assertThat(itr.next())
					.isEqualTo(honux)
					.extracting(Car::getDistance)
					.isEqualTo(Distance.of(1));
			assertThat(itr.hasNext())
					.isFalse();
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
