package racinggame.racingcar;

import java.util.Objects;

import racinggame.common.Name;

public class LapRecord {
	private static final String DELIMITER = "-";

	private final Name name;
	private final Location score;

	/**
	 * {@link Name} 	: 레이싱카의 이름
	 * {@link Location} : 레이싱카의 현재 기록
	 *
	 * 레이싱카의 기록을 기록한다.
	 *
	 * @param name
	 * @param score
	 */
	public LapRecord(Name name, Location score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name.valueOf();
	}

	/**
	 * 현재 기록을 DELIMITER 로 표현한다.
	 * @return String
	 */
	public String read() {
		return new StringBuilder()
			.append(name.valueOf())
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
		return name.equals(lapRecord.name) && score.equals(lapRecord.score);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, score);
	}
}
