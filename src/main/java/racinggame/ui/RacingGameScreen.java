package racinggame.ui;

import racinggame.circuit.FinalRecord;
import racinggame.circuit.RacingCircuit;
import racinggame.dice.TenSidedDice;
import racinggame.racinggame.Circuit;
import racinggame.racinggame.RacingGame;
import racinggame.racinggame.Rule;
import racinggame.rule.RacingRule;
import racinggame.rule.winnerrules.FarAwayWinRule;
import racinggame.ui.config.RacingGameConfig;
import racinggame.ui.input.ConsoleKeyboard;
import racinggame.ui.output.ConsolePrinter;

public final class RacingGameScreen {
	private Settings settings;
	private FinalRecord finalRecord;

	public void on() {
		gameSetting();
		play();
		printResult();
	}

	private void gameSetting() {
		settings = new RacingGameConfig(
			new ConsoleKeyboard(),
			new ConsolePrinter())
			.configGame();
	}

	private void play (){
		Circuit circuit = new RacingCircuit(
			new TenSidedDice(),
			new RacingRule(
				new FarAwayWinRule()
			)
		);

		RacingGame racingGame = new RacingGame(circuit);
		finalRecord = racingGame.play(settings.getRacingCars(), settings.getLap());
	}

	private void printResult (){
		Rule rule = new RacingRule(new FarAwayWinRule());
		ConsolePrinter printer = new ConsolePrinter();

		String result = new StringBuilder()
			.append("실행결과\n")
			.append(finalRecord.readFinalRecord())
			.append("최종 우승자는 ").append(rule.judgeWinners(finalRecord).getNamesWithDelimiter(",")).append(" 입니다.")
			.toString();

		printer.print(result);
	}
}
