package racinggame.machine;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.test.NSTest;
import racinggame.circuit.RacingCircuit;
import racinggame.circuit.dice.TenSidedDice;
import racinggame.exception.InvalidNumberException;
import racinggame.racinggame.RacingGame;
import racinggame.circuit.racingrule.RacingMovementRule;
import racinggame.machine.winnerrule.FarAwayWinRule;
import racinggame.machine.config.RacingGameConfig;
import racinggame.machine.input.ConsoleKeyboard;
import racinggame.machine.output.ConsolePrinter;

class RacingGameMachineTest extends NSTest {
	private static final String ERROR_MESSAGE = "[ERROR]";

	private RacingGameMachine screen;

	@BeforeEach
	void beforeEach() {
		setUp();

		screen = RacingGameScreenConfig.screen();
	}

	@DisplayName("자동차 이름, 랩 등록 성공")
	@Test
	void success() {
		assertSimpleTest(() -> run("pobi,woni", "1"));
	}

	@DisplayName("레이싱카 이름이 5자를 초과하면 [ERROR]가 발생한다.")
	@Test
	void racingCarNameFail() {
		assertSimpleTest(() -> {
			runNoLineFound("pobi,javaji");
			verify(ERROR_MESSAGE);
		});
	}

	@DisplayName("랩 수를 0이하 음수를 등록하면 [ERROR]가 발생한다.")
	@Test
	void wrongLaps() {
		assertSimpleTest(() -> {
			assertThatThrownBy(() -> run("pobi,woni", "0"))
				.isInstanceOf(InvalidNumberException.class)
				.hasMessage("[ERROR] 1 이상 자연수를 입력하세요.");
		});
	}

	@Override
	protected void runMain() {
		screen.turnOn();
	}

	@AfterEach
	void tearDown() {
		outputStandard();
	}

	private static class RacingGameScreenConfig {
		static RacingGameMachine screen() {
			return new RacingGameMachine(config(), game(), winnerDecisionRule(), outputDevice());
		}

		private static RacingGameConfig config() {
			return new RacingGameConfig(new ConsoleKeyboard(), outputDevice());
		}

		private static RacingGame game() {
			return new RacingGame(
				new RacingCircuit(
					new TenSidedDice(),
					new RacingMovementRule()
				)
			);
		}

		private static WinnerDecisionRule winnerDecisionRule() {
			return new FarAwayWinRule();
		}

		private static OutputDevice outputDevice() {
			return new ConsolePrinter();
		}
	}
}