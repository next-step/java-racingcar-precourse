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
import racinggame.circuit.dice.TenSidedDice;
import racinggame.racingcar.LapRecord;
import racinggame.racingcar.Location;
import racinggame.common.RacingCarName;
import racinggame.racingcar.RacingCar;
import racinggame.circuit.racingrule.RacingMovementRule;

class RacingCarsTest {
	private static final int FORWARD = 4;
	private static final int STOP = 3;

	private RacingCars racingCars;
	private MovementRule movementRule;
	private Dice dice;

	@BeforeEach
	void beforeEach() {
		racingCars = RacingCarsConfig.racingCars();
		movementRule = RacingCarsConfig.rule();
		dice = RacingCarsConfig.dice();
	}

	@DisplayName("이동 - Record 를 확인한다.")
	@Test
	void lap_forward() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			//given
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(FORWARD);

			LapRecords expected = new LapRecords();
			expected.add(new LapRecord(new RacingCarName("abc1"), new Location(1)));
			expected.add(new LapRecord(new RacingCarName("abc2"), new Location(1)));

			//when
			LapRecords lapRecords = racingCars.run(dice, movementRule);

			//then
			Assertions.assertThat(lapRecords).isEqualTo(expected);
		}
	}

	@DisplayName("이동 - 결과를 출력한다.")
	@Test
	void lap1_forward_print() {
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
			LapRecords lapRecords = racingCars.run(dice, movementRule);

			//then
			Assertions.assertThat(lapRecords.read()).isEqualTo(expected);
		}
	}

	@DisplayName("정지 - Record 를 확인한다.")
	@Test
	void lapStop() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			//given
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(STOP);

			LapRecords expected = new LapRecords();
			expected.add(new LapRecord(new RacingCarName("abc1"), new Location(0)));
			expected.add(new LapRecord(new RacingCarName("abc2"), new Location(0)));

			//when
			LapRecords lapRecords = racingCars.run(dice, movementRule);

			//then
			Assertions.assertThat(lapRecords).isEqualTo(expected);
		}
	}

	@DisplayName("정지 - 결과를 출력한다.")
	@Test
	void lapStopPrint() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			//given
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(STOP);

			String expected = new StringBuilder()
				.append("abc1 : \n")
				.append("abc2 : \n")
				.append("\n")
				.toString();

			//when
			LapRecords lapRecords = racingCars.run(dice, movementRule);

			//then
			Assertions.assertThat(lapRecords.read()).isEqualTo(expected);
		}
	}

	private static class RacingCarsConfig {
		static RacingCars racingCars() {
			RacingCars racingCars = new RacingCars();

			racingCar().forEach(car -> racingCars.add(car));

			return racingCars;
		}

		static List<RacingCar> racingCar() {
			return Arrays.asList(
				new RacingCar(new RacingCarName("abc1")),
				new RacingCar(new RacingCarName("abc2"))
			);
		}

		static MovementRule rule() {
			return new RacingMovementRule();
		}

		static Dice dice() {
			return new TenSidedDice();
		}
	}
}