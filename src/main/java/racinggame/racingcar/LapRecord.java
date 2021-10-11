package racinggame.racingcar;

import java.util.Objects;

public class LapRecord {
	private final Name name;
	private final int score;

	public LapRecord(Name name, int score) {
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
		return this.score;
	}

	private String drawDash() {
		StringBuilder dashBuilder = new StringBuilder();

		for (int i = 0; i < score; ++i) {
			dashBuilder.append("-");
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
		return score == lapRecord.score && name.equals(lapRecord.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, score);
	}
}
