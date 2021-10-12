package racinggame;

import racinggame.circuit.RacingCircuit;
import racinggame.device.input.ConsoleKeyboard;
import racinggame.device.output.ConsolePrinter;
import racinggame.rule.RacingRule;
import racinggame.rule.winnerrules.FarAwayWinRule;
import racinggame.ui.RacingGame;
import racinggame.ui.Rule;

public class Application {
	public static void main(String[] args) {
		Rule rule = new RacingRule(new FarAwayWinRule());

		RacingGame racingGame = new RacingGame(
			new ConsoleKeyboard(),
			new ConsolePrinter(),
			new RacingCircuit(rule),
			rule
		);

		racingGame.play();
	}
}
