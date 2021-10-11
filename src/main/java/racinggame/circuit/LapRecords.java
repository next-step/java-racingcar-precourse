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

	public List<LapRecord> getLapRecords () {
		return new ArrayList<>(lapRecords);
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
