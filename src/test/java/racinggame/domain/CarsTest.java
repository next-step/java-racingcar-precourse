package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racinggame.exception.DuplicatedCarNameException;
import racinggame.functional.ForwardMoveRule;

class CarsTest {
	@Test
	@DisplayName("Cars 객체는 중복된 자동차 이름이 존재되면 생성할 수 없다.")
	void create_error() {
		// given
		String name = "gmoon";
		List<Car> duplicatedNameCars = Arrays.asList(Car.createNew(name), Car.createNew(name));

		// when

		// then
		assertThatThrownBy(() -> new Cars(duplicatedNameCars))
			.isInstanceOf(DuplicatedCarNameException.class)
			.hasMessage("Can not create Cars instance. Because of There is a duplicate car name.");
	}

	@Test
	@DisplayName("자동차들을 경주시킨다.")
	void startRace() {
		// given
		ForwardMoveRule alwaysForwardMove = ForwardMoveRule.alwaysForwardMove();
		Car gmoon = Car.createNew("gmoon");
		Car guest = Car.createNew("guest");

		// when
		Cars actual = new Cars(Arrays.asList(gmoon, guest))
			.startRace(alwaysForwardMove);

		// then
		Car movedCarOfGmoon = gmoon.moveOrStop(alwaysForwardMove);
		Car movedCarOfGuest = guest.moveOrStop(alwaysForwardMove);
		assertThat(actual)
			.isEqualTo(new Cars(Arrays.asList(movedCarOfGmoon, movedCarOfGuest)));
	}

	@Test
	@DisplayName("자동차 이름을 반환한다.")
	void getCarNames() {
		// given
		String gmoon = "gmoon";
		String guest = "guest";
		Cars cars = new Cars(Arrays.asList(Car.createNew(gmoon), Car.createNew(guest)));

		// when
		List<Name> carNames = cars.getCarNames();

		// then
		assertThat(carNames)
			.containsExactly(new Name(gmoon), new Name(guest));
	}
}