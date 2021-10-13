package racinggame.machine;

import racinggame.circuit.FinalRecord;
import racinggame.racinggame.RacingGame;
import racinggame.machine.winnerrule.WinnerNames;
import racinggame.machine.config.RacingGameConfig;

public final class RacingGameMachine {
	private final RacingGameConfig config;
	private final RacingGame game;
	private final WinnerDecisionRule rule;
	private final OutputDevice outputDevice;

	public RacingGameMachine(RacingGameConfig config, RacingGame game,
		WinnerDecisionRule rule, OutputDevice outputDevice) {
		this.config = config;
		this.game = game;
		this.rule = rule;
		this.outputDevice = outputDevice;
	}

	/**
	 *  게임을 시작한다.
	 *  - 게임 설정을 한다. (레이싱카, 랩수 입력)
	 *  - 게임을 진행한다.
	 *  - 결과를 분석한다.
	 *  - 결과를 출력한다.
	 */
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
