package racinggame.ui;

import racinggame.circuit.FinalRecord;
import racinggame.racinggame.RacingGame;
import racinggame.rule.winnerrules.WinnerDecisionRule;
import racinggame.rule.winnerrules.WinnerNames;
import racinggame.ui.config.RacingGameConfig;

public final class RacingGameScreen {
	private final RacingGameConfig config;
	private final RacingGame game;
	private final WinnerDecisionRule rule;
	private final OutputDevice outputDevice;

	public RacingGameScreen(RacingGameConfig config, RacingGame game,
							WinnerDecisionRule rule, OutputDevice outputDevice) {
		this.config = config;
		this.game = game;
		this.rule = rule;
		this.outputDevice = outputDevice;
	}

	public void turnOn() {
		Settings settings = config.configGame();
		FinalRecord finalRecord = game.play(settings.getRacingCars(), settings.getLap());
		WinnerNames winnerNames = rule.judgeWinner(finalRecord);
		printResult(finalRecord, winnerNames);
	}

	private void printResult(FinalRecord finalRecord, WinnerNames winnerNames) {
		String result = new StringBuilder()
			.append("실행결과\n")
			.append(finalRecord.readFinalRecord())
			.append("최종 우승자는 ")
			.append(winners(winnerNames, ","))
			.append(" 입니다.")
			.toString();

		outputDevice.print(result);
	}

	private String winners(WinnerNames winnerNames, String delimiter) {
		return winnerNames.getNamesWithDelimiter(delimiter);
	}
}
