package racinggame.racingcar;

import java.util.Objects;

import racinggame.common.RacingCarName;

public class LapRecord {
	private static final String DELIMITER = "-";

	private final RacingCarName racingCarName;
	private final Location score;

	/**
	 * {@link RacingCarName} 	: 레이싱카의 이름
	 * {@link Location} 		: 레이싱카의 현재 기록
	 *
	 * 레이싱카의 기록을 기록한다.
	 *
	 * @param racingCarName
	 * @param score
	 */
	public LapRecord(RacingCarName racingCarName, Location score) {
		this.racingCarName = racingCarName;
		this.score = score;
	}

	public String getName() {
		return racingCarName.valueOf();
	}

	/**
	 * 현재 기록을 DELIMITER 로 표현한다.
	 * @return String
	 */
	public String read() {
		return new StringBuilder()
			.append(racingCarName.valueOf())
			.append(" : ")
			.append(drawDash())
			.append("\n")
			.toString();
	}

	public int getScore() {
		return this.score.valueOf();
	}

	private String drawDash() {
		StringBuilder dashBuilder = new StringBuilder();

		for (int i = 0; i < score.valueOf(); ++i) {
			dashBuilder.append(DELIMITER);
		}

		return dashBuilder.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LapRecord lapRecord = (LapRecord)o;
		return racingCarName.equals(lapRecord.racingCarName) && score.equals(lapRecord.score);
	}

	@Override
	public int hashCode() {
		return Objects.hash(racingCarName, score);
	}
}
