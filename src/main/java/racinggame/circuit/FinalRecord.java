package racinggame.circuit;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class FinalRecord {
	private final List<LapRecords> allRecords = new ArrayList<>();

	public void add(LapRecords lapRecords) {
		allRecords.add(lapRecords);
	}

	public String readFinalRecord() {
		StringBuilder finalRecordBuilder = new StringBuilder();

		for (LapRecords record : allRecords) {
			finalRecordBuilder.append(record.write());
		}

		return finalRecordBuilder.toString();
	}

	public LapRecords finalLapRecords() {
		return allRecords.get(lastIndex());
	}

	private int lastIndex() {
		int size = allRecords.size();
		if (size > 0) {
			return size - 1;
		}
		return size;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		FinalRecord that = (FinalRecord)o;
		return allRecords.equals(that.allRecords);
	}

	@Override
	public int hashCode() {
		return Objects.hash(allRecords);
	}
}
