package domain.car;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.car.name.CarNames;
import domain.car.result.CarMoveResults;
import domain.car.strategy.ConditionMovableStrategy;

class CarsTest {

	@Test
	@DisplayName("자동차들을 받아 생성한다")
	void create(){
		CarNames carNames = new CarNames("test,1213,pobi");

		Cars cars = Cars.of(carNames);

		assertThat(cars).isNotNull();
	}

	@Test
	@DisplayName("자동차들의 move를 전부 호출 후 결과를 리턴")
	void move(){
		int expectedSize = 3;
		CarNames carNames = new CarNames("test,1213,pobi");
		Cars cars = Cars.of(carNames);

		cars.move();
		CarMoveResults results = cars.getCurrentMoveResults();

		assertThat(results).isNotNull();
		assertThat(results.getCarMoveResults().size()).isEqualTo(expectedSize);
	}

}
