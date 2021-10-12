package racinggame.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

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
		List<String> carNames = cars.getCarNames();

		// then
		assertThat(carNames)
			.containsExactly(gmoon, guest);
	}

	@Test
	@DisplayName("거리끼리 그룹화하여 Map 타입을 반환한다.")
	void getSamePositionCarsGroup() {
		// given
		Car gmoon = Car.createNew("gmoon").moveOrStop(ForwardMoveRule.alwaysForwardMove());
		Car guest = Car.createNew("guest");
		Cars cars = new Cars(Arrays.asList(gmoon, guest));

		// when
		Map<Position, Cars> positionCarsGroup = cars.getSamePositionCarsGroup();

		// then
		assertAll(
			() -> assertThat(positionCarsGroup)
				.containsEntry(Position.createMinPosition(), new Cars(Collections.singletonList(guest))),
			() -> assertThat(positionCarsGroup)
				.containsEntry(new Position(1), new Cars(Collections.singletonList(gmoon)))
		);
	}

	@Test
	@DisplayName("자동차들의 거리중 최대 거리를 반환한다.")
	void getMaxPosition() {
		// given
		Car gmoon = Car.createNew("gmoon")
			.moveOrStop(ForwardMoveRule.alwaysForwardMove())
			.moveOrStop(ForwardMoveRule.alwaysForwardMove());
		Car guest = Car.createNew("guest");

		Cars cars = new Cars(Arrays.asList(gmoon, guest));

		// when
		Position maxPosition = cars.getMaxPosition();

		// then
		assertThat(maxPosition).isEqualTo(new Position(2));
	}
}