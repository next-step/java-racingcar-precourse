package racinggame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.strategy.AlwaysMoveStrategy;
import racinggame.strategy.NoMoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;


public class CarTest {
	@Test
	@DisplayName("자동차 전진")
	void move() {
		Car car = new Car("car", new AlwaysMoveStrategy());
		car.move();
		assertThat(car.getDistance()).isEqualTo(1);
	}

	@Test
	@DisplayName("자동차 정지")
	void stop() {
		Car car = new Car("car", new NoMoveStrategy());
		car.move();
		assertThat(car.getDistance()).isEqualTo(0);
	}
}
