package racinggame;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import nextstep.utils.Randoms;

public class RacingCarTest {
	private static MockedStatic<Randoms> mockRandoms;

	@BeforeEach
	void setUp() {
		mockRandoms = mockStatic(Randoms.class);
		mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
			.thenReturn(4, 3, 0, 9);
	}

	@AfterEach
	void close() {
		mockRandoms.close();
	}

	@Test
	void 전진_정지_테스트() {
		RacingCar car = new RacingCar("pobi");
		Position position;

		position = car.move();
		position = car.move();
		position = car.move();
		position = car.move();

		assertThat(position.getX()).isEqualTo(2);
	}

	@Test
	void 전진_정지_여러번_테스트() {
		RacingCar car = new RacingCar("pobi");
		Position position;
		mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
			.thenReturn(4, 3, 0, 9);

		position = car.moves(4);

		assertThat(position.getX()).isEqualTo(2);
	}
}
