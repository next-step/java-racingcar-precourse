package racinggame.racingcar;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

import nextstep.utils.Randoms;
import racinggame.rule.RacingRule;
import racinggame.ui.Rule;

class RacingCarTest {
	private RacingCar racingCar;

	@BeforeEach
	void beforeEach() {
		racingCar = RacingCarConfig.racingCar();
	}

	@DisplayName("주사위가 4 이상, 9 이하이면 한 칸 이동한다.")
	@ParameterizedTest
	@ValueSource(ints = {4, 5, 6, 7, 8, 9})
	void move(int diceValue) {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			//given
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(diceValue);
			LapRecord pastLapRecord = racingCar.record();

			//when
			racingCar.pushPedal();

			//then
			LapRecord currentLapRecord = racingCar.record();
			assertThat(currentLapRecord.getScore()).isEqualTo(pastLapRecord.getScore() + 1);
		}
	}

	@DisplayName("주사위가 0 이상, 3 이하이면 움직이지 않는다.")
	@ParameterizedTest
	@ValueSource(ints = {0, 1, 2, 3})
	void stop(int diceValue) {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			//given
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(diceValue);

			LapRecord pastLapRecord = racingCar.record();

			//when
			racingCar.pushPedal();

			//then
			LapRecord currentLabRecord = racingCar.record();
			assertThat(currentLabRecord.getScore()).isEqualTo(pastLapRecord.getScore());
		}
	}

	static class RacingCarConfig {
		static RacingCar racingCar() {
			Dice dice = new Dice(rule().diceMin(), rule().diceMax());
			return new RacingCar("abc", dice, rule());
		}

		static Rule rule() {
			return new RacingRule();
		}
	}
}