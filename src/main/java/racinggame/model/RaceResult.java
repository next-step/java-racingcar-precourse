package racinggame.model;

import static nextstep.utils.Constants.*;

import com.sun.javafx.binding.StringFormatter;

public class RaceResult {
	private static final String RUN_RESULT_MESSAGE = "실행 결과";
	private static final String PRINT_WINNER_MESSAGE = "최종 우승자는 %s 입니다.";

	private StringBuilder raceResultStringBuilder;

	public RaceResult() {
		this.raceResultStringBuilder = appendRunResultMessage();
	}

	public void appendRoundResult(final String roundResult) {
		raceResultStringBuilder.append(roundResult);
		raceResultStringBuilder.append(LINE_CHANGE);
	}

	public String getRaceResult() {
		return raceResultStringBuilder.toString();
	}

	private StringBuilder appendRunResultMessage() {
		raceResultStringBuilder = new StringBuilder();
		raceResultStringBuilder.append(RUN_RESULT_MESSAGE);
		return raceResultStringBuilder.append(LINE_CHANGE);
	}

	public void appendWinner(Winner winner) {
		raceResultStringBuilder.append(StringFormatter.format(PRINT_WINNER_MESSAGE, winner.getWinnerName()).get());
	}
}
