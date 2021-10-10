package racinggame.circuit;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import racinggame.racingcar.LapRecord;

public final class LapRecords {
	private List<LapRecord> lapRecords = new ArrayList<>();

	public void add(LapRecord lapRecord) {
		lapRecords.add(lapRecord);
	}

	public String write() {
		StringBuilder lapRecordBuilder = new StringBuilder();

		for (LapRecord record : lapRecords) {
			lapRecordBuilder.append(record.write());
		}
		lapRecordBuilder.append("\n");

		return lapRecordBuilder.toString();
	}

	public List<String> lapWinners() {
		int farthest = farthest();
		List<LapRecord> winners = new ArrayList<>();

		for (LapRecord record : lapRecords) {
			if (record.getScore() == farthest) {
				winners.add(record);
			}
		}

		return new ArrayList<>(namesOf(winners));
	}

	private int farthest() {
		int score = 0;

		for (LapRecord lapRecord : lapRecords) {
			score = Math.max(score, lapRecord.getScore());
		}

		return score;
	}

	private List<String> namesOf(List<LapRecord> winnersRecord) {
		List<String> winnerNames = new ArrayList<>();

		for (LapRecord record : winnersRecord) {
			winnerNames.add(record.getName());
		}

		return winnerNames;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LapRecords that = (LapRecords)o;
		return lapRecords.equals(that.lapRecords);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lapRecords);
	}
}
