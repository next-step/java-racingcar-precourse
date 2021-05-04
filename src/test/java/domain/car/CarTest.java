package domain.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.car.strategy.ConditionMovableStrategy;

class CarTest {

	@Test
	@DisplayName("자동차는 이름을 받아서 생성할 수 있다")
	void carInit(){
		String carName = "pobi";

		Car car = Car.of(carName);

		assertThat(car).isNotNull();
	}

	@Test
	@DisplayName("자동차 이름과 위치정보를 가진다.")
	void carNameAndPosition(){
		String carName = "pobi";
		Position position = new Position(1);

		Car car = Car.of(carName, position);

		assertThat(position).isEqualTo(car.getPosition());
		assertThat(CarName.of(carName)).isEqualTo(car.getCarName());
	}

	@Test
	@DisplayName("movable이 true 이면 포지션을 1 증가시킨다.")
	void movableTrueTest(){
		String carName = "pobi";
		Position position = new Position(1);
		Car car = Car.of(carName, position, new ConditionMovableStrategy(true));
		Position expected = new Position(2);

		car.move();

		assertThat(car.getPosition()).isEqualTo(expected);
	}

	@Test
	@DisplayName("movable이 false 이면 포지션을 증가하지 않는다.")
	void movableFalseTest(){
		String carName = "pobi";
		Position position = new Position(1);
		Car car = Car.of(carName, position, new ConditionMovableStrategy(false));
		Position expected = new Position(1);

		car.move();

		assertThat(car.getPosition()).isEqualTo(expected);
	}
}
