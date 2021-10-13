package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import racinggame.exception.ErrorMessage;
import racinggame.exception.InvalidInputException;
import racinggame.strategy.FixedMovableStrategy;

class CarTest {

	@ParameterizedTest
	@ValueSource(strings = {"pobi", "a"})
	void 이름은_5글자_이하만_가능하다_정상(String name) {

		CarName carName = new CarName(name);

		assertThat(carName).isNotNull();
	}

	@ParameterizedTest
	@ValueSource(strings = {"sonata", ""})
	void 이름은_5글자_이하만_가능하다_에러(String name) {

		assertThatThrownBy(() -> {
			new CarName(name);
		})
			.isInstanceOf(InvalidInputException.class)
			.hasMessage(ErrorMessage.CAR_NAME_MAX_LENGTH.getMessage())
		;
	}

	@Test
	void 자동차는_이름을_가진다() {
		Car car = new Car("1234");

		CarName carName = car.getCarName();

		assertThat(carName.getName())
			.isNotNull()
			.isEqualTo("1234")
		;
	}

	@Test
	void 처음에는_이동한거리가_0이다() {
		Car car = new Car("pobi");

		int drivenDistance = car.getDrivenDistance();

		assertThat(drivenDistance).isZero();
	}

	@ParameterizedTest
	@CsvSource(value = {"4:1", "3:0", "9:1", "0:0"}, delimiter = ':')
	void 자동차는_전진하거나_멈춘다(int value, int drivenDistance) {
		Car car = new Car("pobi", new FixedMovableStrategy(value));

		car.move();

		assertThat(car.getDrivenDistance()).isEqualTo(drivenDistance);
	}
}