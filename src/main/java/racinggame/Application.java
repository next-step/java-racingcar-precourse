package racinggame;

import racinggame.circuit.RacingCircuit;
import racinggame.device.input.ConsoleKeyboard;
import racinggame.device.output.ConsolePrinter;
import racinggame.rule.RacingRule;
import racinggame.ui.RacingGame;
import racinggame.ui.Rule;

public class Application {
	public static void main(String[] args) {
		Rule rule = new RacingRule();
		RacingCircuit circuit = new RacingCircuit(rule);
		RacingGame racingGame = new RacingGame(
			new ConsoleKeyboard(),
			new ConsolePrinter(),
			circuit,
			rule
		);

		racingGame.play();
	}
}
