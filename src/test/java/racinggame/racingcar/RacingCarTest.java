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
import racinggame.common.Name;
import racinggame.rule.RacingRule;
import racinggame.rule.WinnerDecisionRule;
import racinggame.rule.winnerrules.FarAwayWinRule;
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
			LapRecord pastLapRecord = new LapRecord(new Name("abc"), new Location(0));

			//when
			LapRecord currentLapRecord = racingCar.pushPedal();

			//then
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

			LapRecord pastLapRecord = new LapRecord(new Name("abc"), new Location(0));

			//when
			LapRecord currentLabRecord = racingCar.pushPedal();

			//then
			assertThat(currentLabRecord.getScore()).isEqualTo(pastLapRecord.getScore());
		}
	}

	static class RacingCarConfig {
		static RacingCar racingCar() {
			Dice dice = new Dice(rule().diceMin(), rule().diceMax());
			return new RacingCar(new Name("abc"), dice, rule());
		}

		static Rule rule() {
			return new RacingRule(winner());
		}

		static WinnerDecisionRule winner() {
			return new FarAwayWinRule();
		}
	}
}