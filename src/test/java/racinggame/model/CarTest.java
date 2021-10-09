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

	@Test
	void 정지() {
		Car car = new Car("bus");
		assertThat(car.play(0)).isEqualTo(CarPlayResult.STOP);
		assertThat(car.play(3)).isEqualTo(CarPlayResult.STOP);
	}

	@Test
	void 전진() {
		Car car = new Car("bus");
		assertThat(car.play(4)).isEqualTo(CarPlayResult.FORWARD);
		assertThat(car.play(9)).isEqualTo(CarPlayResult.FORWARD);
	}
}
