package model;

import nextstep.utils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

class CarTest {

	private Car testCar;
	private final String carName = "test-car";

	@BeforeEach
	void init() {
		testCar = new Car(carName);
	}

	@Test
	void createCarTest() {
		assertEquals(carName, testCar.getName());
	}

	@Test
	@DisplayName("자동차 이동 검증")
	void carMoveTest() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(3, 4);
			testCar.move();
			assertThat(testCar.getDistance()).isZero();
			testCar.move();
			assertThat(testCar.getDistance()).isEqualTo(1);
		}
	}
}
