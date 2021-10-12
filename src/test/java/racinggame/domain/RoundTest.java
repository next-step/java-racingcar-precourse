package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racinggame.exception.UnsatisfiedMinimumValueException;

class RoundTest {
	Cars cars;

	@BeforeEach
	void setUp() {
		List<Car> list = Arrays.asList(Car.createNew("gmoon"), Car.createNew("guest"));
		cars = new Cars(list);
	}

	@Test
	@DisplayName("라운드 생성시 게임 횟수는 최소 0 이상 이어야한다.")
	void create_error() {
		// given

		// then
		assertThatThrownBy(() -> new Round(cars, new RaceCount(-1)))
			.isInstanceOf(UnsatisfiedMinimumValueException.class)
			.hasMessage("The value must be at least greater than %d.", 0);
	}

	@Test
	@DisplayName("라운드에 해당되는 자동차들을 경주시킨다.")
	void startRacingCars() {
		// given
		Round round = new Round(cars, new RaceCount(1));

		// when
		round = round.startRacingCars();

		// then
		assertThat(round.isRemainingCount()).isFalse();
	}
}