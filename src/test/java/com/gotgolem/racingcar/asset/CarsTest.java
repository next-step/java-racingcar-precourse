package com.gotgolem.racingcar.asset;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class CarsTest {

	@Test
	public void createSuccess() {
		final List<Car> cars = Collections.singletonList(new Car("A"));
		assertThatCode(() -> new Cars(cars))
				.doesNotThrowAnyException();
	}

	@ParameterizedTest
	@NullAndEmptySource
	public void createFail(final List<Car> cars) {
		assertThatIllegalArgumentException().isThrownBy(() -> new Cars(cars));
	}

	@Test
	public void size() {
		final Car carOne = new Car("one");
		final Car carTwo = new Car("two");
		final Cars cars = new Cars(Arrays.asList(carOne, carTwo));

		assertThat(cars.size())
				.isEqualTo(cars.size());
	}

	@Test
	public void pick() {
		final Car carA = new Car("A");
		final Car carB = new Car("B");
		final Car carC = new Car("C");
		final Cars cars = new Cars(Arrays.asList(carA, carB, carC));

		assertThat(cars.getCar(0))
				.isEqualTo(carA)
				.isNotEqualTo(carB)
				.isNotEqualTo(carC);

		assertThatExceptionOfType(IndexOutOfBoundsException.class)
				.isThrownBy(() -> cars.getCar(3));
	}

	@Test
	public void getTopMileageCars() {
		final Car carA = new Car("A");
		final Car carB = new Car("B");
		final Car carC = new Car("C");
		final Car carD = new Car("D");
		final Cars cars = new Cars(Arrays.asList(carA, carB, carC, carD));

		final Driving driving = new Driving(9);

		carA.drive(driving);
		carC.drive(driving);

		final Cars topMileageCars = cars.getTopMileageCars();

		assertThat(topMileageCars.size())
				.isEqualTo(2);

		assertThat(topMileageCars.getCar(0))
				.isEqualTo(carA);

		assertThat(topMileageCars.getCar(1))
				.isEqualTo(carC);
	}

}
