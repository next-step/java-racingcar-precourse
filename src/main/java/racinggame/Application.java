package racinggame;

import racinggame.circuit.RacingCircuit;
import racinggame.racinggame.RacingGame;
import racinggame.racinggame.Rule;
import racinggame.rule.RacingRule;
import racinggame.rule.winnerrules.FarAwayWinRule;
import racinggame.ui.input.ConsoleKeyboard;
import racinggame.ui.output.ConsolePrinter;

public class Application {
	public static void main(String[] args) {
		Rule rule = new RacingRule(new FarAwayWinRule());

		RacingGame racingGame = new RacingGame(
			new ConsoleKeyboard(),
			new ConsolePrinter(),
			new RacingCircuit(),
			rule
		);

		racingGame.play();
	}
}
