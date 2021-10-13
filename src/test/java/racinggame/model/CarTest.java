package racinggame.model;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;

import nextstep.utils.Randoms;

class CarTest {
	private Car car;

	@BeforeEach
	void setUp() {
		car = new Car("tom");
	}

	@DisplayName("랜덤 숫자가 3 이하일 경우 자동차 액션이 STOP, 4이상일 경우 GO 인지 테스트")
	@ParameterizedTest
	@CsvSource(value = {"0:STOP", "3:STOP", "4:GO", "9:GO"}, delimiter = ':')
	void chooseAction(int num, CarAction carAction) {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms
				.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(num);
			assertThat(car.chooseAction()).isEqualTo(carAction);
		}
	}

	@DisplayName("자동차의 액션이 GO 인 경우 포지션의 이동을 테스트")
	@Test
	void move() {
		int currentPosition = car.getPosition();
		car.move(CarAction.GO);
		assertThat(currentPosition).isNotEqualTo(car.getPosition());
	}

	@DisplayName("자동차의 액션이 STOP 인 경우 포지션의 이동을 테스트")
	@Test
	void moveNot() {
		int currentPosition = car.getPosition();
		car.move(CarAction.STOP);
		assertThat(currentPosition).isEqualTo(car.getPosition());
	}

	@DisplayName("자동차의 액션에 따른 포지션의 이동을 테스트")
	@Test
	void getPosition() {
		car.move(CarAction.STOP);
		assertThat(car.getPosition()).isEqualTo(0);
		car.move(CarAction.GO);
		assertThat(car.getPosition()).isEqualTo(1);
	}
}