package racinggame;

import racinggame.circuit.RacingCircuit;
import racinggame.circuit.dice.TenSidedDice;
import racinggame.racinggame.RacingGame;
import racinggame.circuit.racingrule.RacingMovementRule;
import racinggame.machine.winnerrule.FarAwayWinRule;
import racinggame.machine.WinnerDecisionRule;
import racinggame.machine.OutputDevice;
import racinggame.machine.RacingGameMachine;
import racinggame.machine.config.RacingGameConfig;
import racinggame.machine.input.ConsoleKeyboard;
import racinggame.machine.output.ConsolePrinter;

public class Application {
	public static void main(String[] args) {
		new RacingGameMachine(config(), game(), winnerDecisionRule(), outputDevice())
			.turnOn();
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

	private static OutputDevice outputDevice(){
		return new ConsolePrinter();
	}
}
