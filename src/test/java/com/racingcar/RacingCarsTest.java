package com.racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class RacingCarsTest {

	@Test
	void 이름_하나만_받는_경우() {
		String input = "test1";

		RacingCars result = RacingCars.of(input);

		assertThat(result.count()).isEqualTo(1);

		assertThat(result.getValues().get(0).getName().getValue()).isEqualTo("test1");
		assertThat(result.getValues().get(0).getLocation().getValue()).isEqualTo(0);
	}

	@Test
	void 이름_2개_받는_경우() {
		String input = "test1,test2";

		RacingCars result = RacingCars.of(input);

		assertThat(result.count()).isEqualTo(2);

		assertThat(result.getValues().get(0).getName().getValue()).isEqualTo("test1");
		assertThat(result.getValues().get(0).getLocation().getValue()).isEqualTo(0);

		assertThat(result.getValues().get(1).getName().getValue()).isEqualTo("test2");
		assertThat(result.getValues().get(1).getLocation().getValue()).isEqualTo(0);
	}

	@Test
	void 우승자_한_명만_있는_경우() {
		RacingCar car1 = RacingCar.of(Name.of("test1"));
		RacingCar car2 = RacingCar.of(Name.of("test2"));

		List<RacingCar> cars = new ArrayList<>();
		cars.add(car1);
		cars.add(car2);

		car2.increaseLocation();

		RacingCars racingCars = new RacingCars(cars);
		RacingCars result = racingCars.winners();

		assertThat(result.count()).isEqualTo(1);
		assertThat(result.getValues().get(0).getName().getValue()).isEqualTo("test2");
	}

	@Test
	void 우승자_두_명인_경우() {
		RacingCar car1 = RacingCar.of(Name.of("test1"));
		RacingCar car2 = RacingCar.of(Name.of("test2"));
		RacingCar car3 = RacingCar.of(Name.of("test3"));

		List<RacingCar> cars = new ArrayList<>();
		cars.add(car1);
		cars.add(car2);
		cars.add(car3);

		car2.increaseLocation();
		car3.increaseLocation();

		RacingCars racingCars = new RacingCars(cars);
		RacingCars result = racingCars.winners();

		assertThat(result.count()).isEqualTo(2);
		assertThat(result.getValues().get(0).getName().getValue()).isEqualTo("test2");
		assertThat(result.getValues().get(1).getName().getValue()).isEqualTo("test3");
	}
}