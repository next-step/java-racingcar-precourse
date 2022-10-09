package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import racingcar.domain.Car;

public class CarPrintTest {
	@Test
	void initalCarTest() {
		Car car = new Car("sang");
		assertThat(car.printStatus()).isEqualTo("sang : \n");
	}
}
