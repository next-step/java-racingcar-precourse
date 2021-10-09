package racinggame.model;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import nextstep.utils.Randoms;

public class CarTest {
	private static final int MOVING_FORWARD = 4;
	private static final int STOP = 3;

	@Test
	void 이름으로_자동차_생성() {
		assertThat(new Car("a"))
				.isInstanceOf(Car.class)
				.extracting(car -> car.getName())
				.isEqualTo("a");
	}

	@Test
	void 정지() {
		Car car = new Car("bus");
		assertThat(car.play(0)).isEqualTo(CarPlayResult.STOP);
		assertThat(car.play(3)).isEqualTo(CarPlayResult.STOP);
	}

	@Test
	void 전진() {
		Car car = new Car("bus");
		assertThat(car.play(4)).isEqualTo(CarPlayResult.FORWARD);
		assertThat(car.play(9)).isEqualTo(CarPlayResult.FORWARD);
	}

	@Test
	void 입력_횟수만큼_움직이고_움직인_총_길이값_반환() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms
					.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
					.thenReturn(MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD);
			Car car = new Car("bus");
			car.roll(4);
			assertThat(car.getTotalTravel()).isEqualTo(3);
		}
	}

}
