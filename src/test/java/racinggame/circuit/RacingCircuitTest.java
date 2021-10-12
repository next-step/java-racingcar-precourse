package racinggame.circuit;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import nextstep.utils.Randoms;
import racinggame.common.RacingCarName;
import racinggame.dice.Dice;
import racinggame.dice.TenSidedDice;
import racinggame.racingcar.RacingCar;
import racinggame.rule.RacingRule;
import racinggame.rule.WinnerDecisionRule;
import racinggame.rule.winnerrules.FarAwayWinRule;
import racinggame.racinggame.Rule;

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

		static Rule rule() {
			return new RacingRule(winner());
		}

		static WinnerDecisionRule winner() {
			return new FarAwayWinRule();
		}

		public static Dice dice() {
			return new TenSidedDice();
		}
	}

}