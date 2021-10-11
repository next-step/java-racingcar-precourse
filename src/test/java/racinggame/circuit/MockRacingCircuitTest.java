package racinggame.circuit;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racinggame.racingcar.Dice;
import racinggame.racingcar.LapRecord;
import racinggame.racingcar.Location;
import racinggame.racingcar.Name;
import racinggame.racingcar.RacingCar;
import racinggame.rule.RacingRule;
import racinggame.ui.Rule;

class MockRacingCircuitTest {
	private RacingCircuit mockRacingCircuit;
	private RacingCars racingCars;
	private Rule rule;
	private Lap lap;

	@BeforeEach
	void beforeEach() {
		mockRacingCircuit = RacingCircuitConfig.mockRacingCircuit();
		rule = RacingCircuitConfig.rule();

		Dice dice = new Dice(rule.diceMin(), rule.diceMax());

		racingCars = new RacingCars(
			Arrays.asList(
				new RacingCar("abc1", dice, rule),
				new RacingCar("abc2", dice, rule)
			)
		);

		lap = new Lap("2");
	}

	@DisplayName("결과 출력 테스트")
	@Test
	void printResult() {
		FinalRecord finalRecord = mockRacingCircuit.start(racingCars, lap);
		assertThat(finalRecord.readFinalRecord()).contains(
			"abc1 : -",
			"abc2 : ",
			"abc1 : --",
			"abc2 : "
		);
	}

	@DisplayName("우승자 확인")
	@Test
	void printWinner() {
		FinalRecord finalRecord = mockRacingCircuit.start(racingCars, lap);
		assertThat(finalRecord.readFinalRecord()).contains("abc1");
	}

	static class RacingCircuitConfig {
		static RacingCircuit mockRacingCircuit() {
			return new RacingCircuit(rule()) {
				@Override
				public FinalRecord start(RacingCars racingCars, Lap laps) {
					return expectedRecord();
				}
			};
		}

		static Rule rule() {
			return new RacingRule();
		}

		private static FinalRecord expectedRecord() {
			LapRecords lap1Records = new LapRecords();
			lap1Records.add(new LapRecord(new Name("abc1"), new Location(1)));
			lap1Records.add(new LapRecord(new Name("abc2"), new Location(0)));

			LapRecords lap2Records = new LapRecords();
			lap2Records.add(new LapRecord(new Name("abc1"), new Location(2)));
			lap2Records.add(new LapRecord(new Name("abc2"), new Location(0)));

			FinalRecord expectedRecord = new FinalRecord();
			expectedRecord.add(lap1Records);
			expectedRecord.add(lap2Records);

			return expectedRecord;
		}
	}
}