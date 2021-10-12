package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racinggame.functional.ForwardMoveRule;

class CarTest {
	@Test
	@DisplayName("초기 자동차는 지정된 이름으로 생성된다. 위치는 0을 가진다.")
	void create() {
		// given
		Name name = new Name("gmoon");

		// when
		Car car = new Car(name, Position.createMinPosition());

		// then
		assertThat(car).isNotNull()
			.isEqualTo(new Car("gmoon"));
	}

	@Test
	@DisplayName("자동차는 앞으로 전진할 수 있다.")
	void move() {
		// given
		Car car = new Car("gmoon");
		ForwardMoveRule alwaysForwardMove = ForwardMoveRule.alwaysForwardMove();

		// when
		car = car.moveOrStop(alwaysForwardMove);
		car = car.moveOrStop(alwaysForwardMove);
		car = car.moveOrStop(alwaysForwardMove);
		car = car.moveOrStop(alwaysForwardMove);

		// then
		assertThat(car)
			.isEqualTo(new Car(new Name("gmoon"), new Position(4)));
	}
}