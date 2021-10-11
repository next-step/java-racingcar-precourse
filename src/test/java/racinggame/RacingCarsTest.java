package racinggame;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import nextstep.utils.Randoms;

public class RacingCarsTest {
	private static MockedStatic<Randoms> mockRandoms;

	@BeforeEach
	void setUp() {
		mockRandoms = mockStatic(Randoms.class);
		mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
			.thenReturn(4);
	}

	@AfterEach
	void close() {
		mockRandoms.close();
	}

	@Test
	void 경기_1회_진행_테스트() {
		String namesInput = "pobi,moon,mike";
		RacingCars racingCars = new RacingCars(new CarNames(namesInput));
		racingCars.move();
		assertThat(racingCars.toString()).isEqualTo("pobi : -\nmoon : -\nmike : -");
	}

	@Test
	void 경기_1회_진행후_승리_테스트() {
		String namesInput = "pobi,moon,mike";
		RacingCars racingCars = new RacingCars(new CarNames(namesInput));
		racingCars.move();
		Winners winners = racingCars.winners();
		assertThat(winners.toString()).isEqualTo("pobi,moon,mike");
	}
}
