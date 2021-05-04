package domain.car.winner;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.car.Car;
import domain.car.Cars;
import domain.car.Position;
import domain.car.strategy.ConditionMovableStrategy;

class WinnersTest {

	@Test
	@DisplayName("우승자는 가장 전진한 자동차이다")
	void winners(){
		Cars cars = Cars.of(
			Arrays.asList(
				makeCar("1번", 2),
				makeCar("2번", 5),
				makeCar("3번", 4),
				makeCar("4번", 5)
			)
		);

		Winners winners = Winners.of(cars.move());

		assertThat(winners).isNotNull();
		assertThat(winners.getWinners())
			.containsExactly(
				Winner.of("2번"), Winner.of("4번")
			);

	}

	private Car makeCar(String carName, int position) {
		return Car.of(carName, new Position(position), new ConditionMovableStrategy(true));
	}
}
