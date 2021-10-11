package racinggame.domain;

import nextstep.utils.Randoms;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import racinggame.dto.ResultDto;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class GameTest {
	private static final int MOVING_FORWARD = 4;
	private static final int STOP = 3;

	@Test
	void startTest() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
					.thenReturn(STOP, STOP, MOVING_FORWARD,
							STOP, MOVING_FORWARD, MOVING_FORWARD,
							MOVING_FORWARD, MOVING_FORWARD, STOP,
							MOVING_FORWARD, STOP, STOP,
							MOVING_FORWARD, MOVING_FORWARD, STOP);
			Car pobi = new Car(Name.of("pobi"));
			Car crong = new Car(Name.of("crong"));
			Car honux = new Car(Name.of("honux"));
			Cars cars = new Cars(Arrays.asList(pobi, crong, honux));
			ResultDto resultDto = Game.ready(cars).start(Count.of(5));
			assertThat(resultDto.getMessage())
					.contains("pobi,crong");
		}
	}
}
