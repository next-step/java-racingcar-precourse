package racinggame.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racinggame.domain.boxing.CarName;
import racinggame.domain.strategy.MoveTestMoveStrategy;
import racinggame.domain.strategy.MoveTestStayStrategy;
import racinggame.domain.strategy.Strategy;
import racinggame.error.ErrorMessage;
import racinggame.error.InvalidCarNameInput;

public class CarTest {

	@DisplayName("자동차 이름 Test - 이름 길이")
	@Test
	void carNameLengthTest() {
		assertThatThrownBy(() -> new CarName("123456"))
			.isInstanceOf(InvalidCarNameInput.class)
			.hasMessageContaining(ErrorMessage.INVALID_CAR_NAME_INPUT);
	}

	@DisplayName("자동차 이름 Test - Empty")
	@Test
	void carNameInvalidTest() {
		assertThatThrownBy(() -> new CarName(""))
			.isInstanceOf(InvalidCarNameInput.class)
			.hasMessageContaining(ErrorMessage.INVALID_CAR_NAME_INPUT);
	}

	@DisplayName("자동차 생성 Test")
	@Test
	void carGenerateTest() {
		CarName carName = new CarName("자동차");
		assertThat(new Car(carName, (new Strategy() {
			@Override
			public boolean isMovable() {
				return true;
			}
		}))).isNotNull();
	}

	@DisplayName("자동차 이동 Test - 전진")
	@Test
	void carMoveTestMove() {
		CarName carName = new CarName("자동차");
		Car car = new Car(carName, new MoveTestMoveStrategy());
		int prePosition = car.getPosition();
		car.move();
		int postPosition = car.getPosition();

		assertThat(prePosition < postPosition).isEqualTo(true);
	}

	@DisplayName("자동차 이동 Test - 멈춤")
	@Test
	void carMoveTestStay() {
		CarName carName = new CarName("자동차");
		Car car = new Car(carName, new MoveTestStayStrategy());
		int prePosition = car.getPosition();
		car.move();
		int postPosition = car.getPosition();

		assertThat(prePosition == postPosition).isEqualTo(true);
	}

}
