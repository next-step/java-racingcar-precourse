package racinggame.model;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import nextstep.utils.Randoms;

public class CarsTest {
	private static final int MOVING_FORWARD = 4;
	private static final int STOP = 3;
	
	@Test
	void 콤마로_구분하여_자동차들_생성() {
		assertThat(new Cars("bus,texi,suv"))
				.isInstanceOf(Cars.class);
	}
	
	@Test
	void 자동차의_현재_상태들을_문자열로_받아올_수_있다() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms
					.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
					.thenReturn(MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP);
			Cars cars = new Cars("bus,texi");
			cars.roll();
			assertThat(cars.getStatus().toString()).isEqualTo("bus : -\ntexi : -\n");
			cars.roll();
			assertThat(cars.getStatus().toString()).isEqualTo("bus : -\ntexi : --\n");
			cars.roll();
			assertThat(cars.getStatus().toString()).isEqualTo("bus : --\ntexi : --\n");
		}
	}
	
	@Test
	void 자동차들중_우승자를_결정() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms
					.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
					.thenReturn(MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD);
			
			Cars cars = new Cars("bus,texi");
			cars.roll();
			cars.roll();
			assertThat(cars.getWinnerNames().toString()).isEqualTo("texi");
		}
	}
	
	@Test
	void 우승자가_여러명일_경우() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms
					.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
					.thenReturn(MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP);
			
			Cars cars = new Cars("bus,texi,suv");
			cars.roll();
			cars.roll();
			assertThat(cars.getWinnerNames().toString()).isEqualTo("bus,texi");
		}
	}
}
