package com.gotgolem.racingcar.asset;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

	@ParameterizedTest
	@ValueSource(strings = {"A", "A B", "AAA", "APPLE", "J V M"})
	public void createSuccess(final String carName) {
		assertThatCode(() -> new Car(carName))
				.doesNotThrowAnyException();
		assertThat(new Car(carName).getName())
				.isEqualTo(carName);
	}

	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {"moby-dick", "SIXSIX", "123456", "APPLES", "Oh M Y"})
	public void createFail(final String carName) {
		assertThatIllegalArgumentException().isThrownBy(() -> new Car(carName));
	}

	@Test
	public void stopCar() {
		final Car car = new Car("A");
		final Driving driving = new Driving(3);

		car.drive(driving);
		assertThat(car.getMileage())
				.isEqualTo(0);

		car.drive(driving);
		assertThat(car.getMileage())
				.isEqualTo(0);
	}

	@Test
	public void moveCar() {
		final Car car = new Car("B");
		final Driving driving = new Driving(5);

		car.drive(driving);
		assertThat(car.getMileage())
				.isEqualTo(1);

		car.drive(driving);
		assertThat(car.getMileage())
				.isEqualTo(2);
	}

}
