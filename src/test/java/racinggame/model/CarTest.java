package racinggame.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarTest {
	@Test
	void 이름으로_자동차_생성() {
		assertThat(new Car("a"))
				.isInstanceOf(Car.class)
				.extracting(car -> car.getName())
				.isEqualTo("a");
	}
}
