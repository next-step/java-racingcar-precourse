package racinggame.circuit;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racinggame.common.RacingCarName;
import racinggame.dice.Dice;
import racinggame.dice.TenSidedDice;
import racinggame.racingcar.LapRecord;
import racinggame.racingcar.Location;
import racinggame.racingcar.RacingCar;
import racinggame.racinggame.Rule;
import racinggame.rule.RacingRule;
import racinggame.rule.WinnerDecisionRule;
import racinggame.rule.winnerrules.FarAwayWinRule;

class MockRacingCircuitTest {
	private RacingCircuit mockRacingCircuit;
	private RacingCars racingCars;
	private Lap lap;

	@BeforeEach
	void beforeEach() {
		mockRacingCircuit = RacingCircuitConfig.mockRacingCircuit();

		racingCars = new RacingCars();

		racingCars.add(new RacingCar(new RacingCarName("abc1")));
		racingCars.add(new RacingCar(new RacingCarName("abc2")));

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

	private static class RacingCircuitConfig {
		static RacingCircuit mockRacingCircuit() {
			return new RacingCircuit(dice(), rule()) {
				@Override
				public FinalRecord start(RacingCars racingCars, Lap laps) {
					return expectedRecord();
				}
			};
		}

		static Dice dice () {
			return new TenSidedDice();
		}

		static Rule rule() {
			return new RacingRule(winner());
		}

		static WinnerDecisionRule winner() {
			return new FarAwayWinRule();
		}

		private static FinalRecord expectedRecord() {
			LapRecords lap1Records = new LapRecords();
			lap1Records.add(new LapRecord(new RacingCarName("abc1"), new Location(1)));
			lap1Records.add(new LapRecord(new RacingCarName("abc2"), new Location(0)));

			LapRecords lap2Records = new LapRecords();
			lap2Records.add(new LapRecord(new RacingCarName("abc1"), new Location(2)));
			lap2Records.add(new LapRecord(new RacingCarName("abc2"), new Location(0)));

			FinalRecord expectedRecord = new FinalRecord();
			expectedRecord.add(lap1Records);
			expectedRecord.add(lap2Records);

			return expectedRecord;
		}
	}
}