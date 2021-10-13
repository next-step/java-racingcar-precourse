package racinggame.model;

import static nextstep.utils.Constants.*;

public class RoundResult {
	private static final String DELIMITER_COLON = " : ";
	private static final String DASH = "-";
	private final StringBuilder roundResultStringBuilder;

	public RoundResult(final StringBuilder roundResultStringBuilder) {
		this.roundResultStringBuilder = roundResultStringBuilder;
	}

	public void appendRoundResult(final Car car) {
		roundResultStringBuilder.append(car.getCarName());
		roundResultStringBuilder.append(DELIMITER_COLON);
		for (int i = 0; i < car.getPosition(); i++) {
			roundResultStringBuilder.append(DASH);
		}
		roundResultStringBuilder.append(LINE_CHANGE);
	}

	public String getRoundResultStr() {
		return roundResultStringBuilder.toString();
	}
}
