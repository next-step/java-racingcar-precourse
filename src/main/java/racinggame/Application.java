package racinggame;

import racinggame.circuit.RacingCircuit;
import racinggame.dice.TenSidedDice;
import racinggame.racinggame.RacingGame;
import racinggame.rule.racing.RacingRule;
import racinggame.rule.winnerrules.FarAwayWinRule;
import racinggame.rule.winnerrules.WinnerDecisionRule;
import racinggame.ui.OutputDevice;
import racinggame.ui.RacingGameScreen;
import racinggame.ui.config.RacingGameConfig;
import racinggame.ui.input.ConsoleKeyboard;
import racinggame.ui.output.ConsolePrinter;

public class Application {
	public static void main(String[] args) {
		new RacingGameScreen(config(), game(), winnerDecisionRule(), outputDevice())
			.turnOn();
	}

	private static RacingGameConfig config() {
		return new RacingGameConfig(new ConsoleKeyboard(), outputDevice());
	}

	private static RacingGame game() {
		return new RacingGame(
			new RacingCircuit(
				new TenSidedDice(),
				new RacingRule()
			)
		);
	}

	private static WinnerDecisionRule winnerDecisionRule() {
		return new FarAwayWinRule();
	}

	private static OutputDevice outputDevice(){
		return new ConsolePrinter();
	}
}
