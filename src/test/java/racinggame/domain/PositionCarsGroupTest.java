package racinggame.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racinggame.functional.ForwardMoveRule;

class PositionCarsGroupTest {
	@Test
	@DisplayName("거리끼리 그룹화하여 PositionCarsGroup 생성한다.")
	void create() {
		// given
		Car gmoon = Car.createNew("gmoon").moveOrStop(ForwardMoveRule.alwaysForwardMove());
		Car guest = Car.createNew("guest");
		Cars cars = new Cars(Arrays.asList(gmoon, guest));

		// when
		PositionCarsGroup group = PositionCarsGroup.from(cars);

		// then
		assertAll(
			() -> assertThat(group.getCars(Position.createMinPosition()))
				.isEqualTo(new Cars(Collections.singletonList(guest))),
			() -> assertThat(group.getCars(new Position(1)))
				.isEqualTo(new Cars(Collections.singletonList(gmoon)))
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

		PositionCarsGroup group = PositionCarsGroup.from(cars);

		// when
		Position maxPosition = group.getMaxPosition();

		// then
		assertThat(maxPosition).isEqualTo(new Position(2));
	}
}