package racinggame.circuit;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import nextstep.utils.Randoms;
import racinggame.racingcar.LapRecord;
import racinggame.racingcar.Name;
import racinggame.racingcar.RacingCar;
import racinggame.rule.RacingRule;
import racinggame.ui.Rule;

class RacingCarsTest {
	private static final int FORWARD = 4;
	private static final int STOP = 4;

	private RacingCars racingCars;

	@BeforeEach
	void beforeEach() {
		racingCars = RacingCarsConfig.racingCars();
	}

	@DisplayName("Record 를 확인한다.")
	@Test
	void lap1() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			//given
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(FORWARD);

			LapRecords expected = new LapRecords();
			expected.add(new LapRecord(new Name("abc1"), 1));
			expected.add(new LapRecord(new Name("abc2"), 1));

			//when
			LapRecords lapRecords = racingCars.run();

			//then
			Assertions.assertThat(lapRecords).isEqualTo(expected);
		}
	}

	@DisplayName("결과를 출력한다.")
	@Test
	void lap1_print (){
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			//given
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(FORWARD);

			String expected = new StringBuilder()
				.append("abc1 : -\n")
				.append("abc2 : -\n")
				.append("\n")
				.toString();

			//when
			LapRecords lapRecords = racingCars.run();

			//then
			Assertions.assertThat(lapRecords.write()).isEqualTo(expected);
		}
	}

	static class RacingCarsConfig {
		static RacingCars racingCars() {
			return new RacingCars(racingCar());
		}

		static List<RacingCar> racingCar() {
			return Arrays.asList(
				new RacingCar(rule(), "abc1"),
				new RacingCar(rule(), "abc2")
			);
		}

		static Rule rule() {
			return new RacingRule();
		}
	}
}