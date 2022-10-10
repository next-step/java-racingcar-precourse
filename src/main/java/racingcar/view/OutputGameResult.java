package racingcar.view;

import java.util.List;

import racingcar.model.GameResult;
import racingcar.model.Round;

public class OutputGameResult {
	public void print(GameResult gameResult) {
		System.out.print("\n");
		System.out.println("실행 결과");
		printRoundsResultList(gameResult);
		printWinnerResult(gameResult);
	}

	private void printRoundsResultList(GameResult gameResult) {
		List<Round> roundResultList = gameResult.getRoundResult().getRoundList();
		for (Round round : roundResultList) {
			printRoundResult(round);
		}
	}

	private void printRoundResult(Round round) {
		round.getCarNameProgress()
			.forEach((carName, progress) ->
				System.out.printf("%s : %s%n", carName.getValue(), progress.getProgressBar()));
		System.out.print("\n");
	}

	private void printWinnerResult(GameResult gameResult) {
		System.out.println("최종 우승자 : " + gameResult.getWinnerResultMessage());
	}
}
