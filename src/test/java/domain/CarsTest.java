package domain;

import nextstep.utils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import racinggame.domain.Car;
import racinggame.domain.Cars;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class CarsTest {
	public static final int MOVING_FORWARD = 4;
	public static final int STOP = 3;

	Cars cars;

	@BeforeEach
	void setUp() {
		cars = new Cars(new String[]{"pobi" ,"crong" ,"honux"});
	}

	@Test
	void 일괄이동() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
					.thenReturn(MOVING_FORWARD, STOP, MOVING_FORWARD);
			cars.move();
			assertThat(cars.get(0).getDistance()).isEqualTo(1);
			assertThat(cars.get(1).getDistance()).isEqualTo(0);
			assertThat(cars.get(2).getDistance()).isEqualTo(1);
		}
	}

	@Test
	void 우승한_자동차_검증() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
					.thenReturn(
							MOVING_FORWARD, MOVING_FORWARD, STOP,
							MOVING_FORWARD, STOP, STOP);
			cars.move(2);
			List<Car> winner = cars.getWinner();
			assertThat(winner.size()).isEqualTo(1);
			assertThat(winner.get(0).getName()).isEqualTo("pobi");
		}
	}

	@Test
	void 우승한_자동차_2대인_경우() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
					.thenReturn(
							MOVING_FORWARD, MOVING_FORWARD, STOP,
							MOVING_FORWARD, MOVING_FORWARD, STOP);
			cars.move(2);
			List<Car> winner = cars.getWinner();
			assertThat(winner.size()).isEqualTo(2);
			assertThat(winner.get(0).getName()).isEqualTo("pobi");
			assertThat(winner.get(1).getName()).isEqualTo("crong");
		}
	}

	@Test
	void 우승한_자동차_2대인_경우2() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
					.thenReturn(
							STOP, MOVING_FORWARD, MOVING_FORWARD,
							STOP, MOVING_FORWARD, MOVING_FORWARD);
			cars.move(2);
			List<Car> winner = cars.getWinner();
			assertThat(winner.size()).isEqualTo(2);
			assertThat(winner.get(0).getName()).isEqualTo("crong");
			assertThat(winner.get(1).getName()).isEqualTo("honux");
		}
	}
}
