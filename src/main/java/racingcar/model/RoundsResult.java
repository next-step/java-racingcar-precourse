package racingcar.model;

import java.util.Collections;
import java.util.List;

public class RoundsResult {
	private final List<Round> RoundList;

	private RoundsResult(List<Round> RoundList) {
		this.RoundList = RoundList;
	}

	public static RoundsResult from(List<Round> roundList) {
		return new RoundsResult(roundList);
	}

	public List<Round> getRoundList() {
		return Collections.unmodifiableList(RoundList);
	}
}
