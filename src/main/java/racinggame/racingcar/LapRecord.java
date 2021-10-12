package racinggame.racingcar;

import java.util.Objects;

public class LapRecord {
	private final String DELIMITER = "-";
	private final Name name;
	private final Location score;

	public LapRecord(Name name, Location score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name.valueOf();
	}

	public String write() {
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
