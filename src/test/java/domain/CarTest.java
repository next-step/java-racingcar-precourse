package domain;

import nextstep.utils.Randoms;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class CarTest {
	private static final String ERROR_MESSAGE = "[ERROR]";
	public static final int MOVING_FORWARD = 4;
	public static final int STOP = 3;

	@Test
	void 생성() {
		String carName = "hanna";
		Car car = new Car(carName);
		assertThat(car.getName()).isEqualTo(carName);
		assertThat(car.getDistance()).isEqualTo(0);
	}

	@Test
	void 이름_5자_초과인_경우_예외처리() {
		assertThatThrownBy(() -> {
			new Car("hannah");
		}).isInstanceOf(Exception.class)
				.hasMessageContaining(ERROR_MESSAGE);
	}

	@Test
	void 전진() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
					.thenReturn(MOVING_FORWARD);
			Car car = new Car("hanna");
			car.move();
			assertThat(car.getDistance()).isEqualTo(1);
		}
	}

	@Test
	void 멈춤() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
					.thenReturn(STOP);
			Car car = new Car("hanna");
			car.move();
			assertThat(car.getDistance()).isEqualTo(0);
		}
	}
}
