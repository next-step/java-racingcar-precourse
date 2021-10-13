package racinggame.circuit;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import nextstep.utils.Randoms;
import racinggame.common.RacingCarName;
import racinggame.circuit.dice.TenSidedDice;
import racinggame.racingcar.RacingCar;
import racinggame.circuit.racingrule.RacingMovementRule;

class RacingCircuitTest {
	private static final int FORWARD = 4;
	private static final int STOP = 3;

	private RacingCircuit racingCircuit;
	private RacingCars racingCars;
	private Dice dice;

	@BeforeEach
	void beforeEach() {
		racingCircuit = RacingCircuitConfig.racingCircuit();
		dice = RacingCircuitConfig.dice();

		racingCars = new RacingCars();
		racingCars.add(new RacingCar(new RacingCarName("abc1")));
		racingCars.add(new RacingCar(new RacingCarName("abc2")));
	}

	@DisplayName("결과 출력")
	@Test
	void printResult() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(FORWARD, STOP, FORWARD, STOP);

			FinalRecord finalRecord = racingCircuit.start(racingCars, new Lap("2"));

			System.out.println(finalRecord.readFinalRecord());
			assertThat(finalRecord.readFinalRecord()).contains("abc1 : --", "abc2 : ");
		}
	}

	@DisplayName("우승자 출력")
	@Test
	void printWinner() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(4, 4, 4, 4);

			FinalRecord finalRecord = racingCircuit.start(racingCars, new Lap("2"));

			assertThat(finalRecord.readFinalRecord()).contains("abc1", "abc2");
		}
	}

	static class RacingCircuitConfig {
		static RacingCircuit racingCircuit() {
			return new RacingCircuit(dice(), rule());
		}

		static MovementRule rule() {
			return new RacingMovementRule();
		}

		public static Dice dice() {
			return new TenSidedDice();
		}
	}

}