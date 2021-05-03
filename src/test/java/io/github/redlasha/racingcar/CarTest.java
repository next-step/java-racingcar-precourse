package io.github.redlasha.racingcar;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

	@Test
	void 차는_4이상이면_전진한다() { // @checkstyle:ignore
		Car car1 = new Car("test1");
		car1.move(4);
		assertThat(car1.getDistance()).isEqualTo(new Distance(1));

		Car car2 = new Car("test2");
		car2.move(9);
		assertThat(car2.getDistance()).isEqualTo(new Distance(1));
	}

	@Test
	void 차는_3이하이면_멈춘다() { // @checkstyle:ignore
		Car car = new Car("test1");

		car.move(0);
		assertThat(car.getDistance()).isEqualTo(new Distance(0));

		car.move(3);
		assertThat(car.getDistance()).isEqualTo(new Distance(0));
	}

}
