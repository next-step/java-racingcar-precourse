package racinggame.circuit;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class FinalRecord {
	private final List<LapRecords> allRecords = new ArrayList<>();

	public void add(LapRecords lapRecords) {
		allRecords.add(lapRecords);
	}

	public String announce() {
		return new StringBuilder()
			.append(record())
			.append("최종 우승자는 ")
			.append(winner())
			.append(" 입니다.")
			.toString();
	}

	private String record() {
		StringBuilder finalRecordBuilder = new StringBuilder();

		for (LapRecords record : allRecords) {
			finalRecordBuilder.append(record.write());
		}

		return finalRecordBuilder.toString();
	}

	private String winner() {
		LapRecords finalLapRecords = finalLapRecords();
		List<String> names = finalLapRecords.lapWinners();

		if (names.size() == 0) {
			return "";
		}

		return makeNamesJoiningDelimiter(names, ",");
	}

	private LapRecords finalLapRecords() {
		return allRecords.get(lastIndex());
	}

	private int lastIndex() {
		int size = allRecords.size();
		if (size > 0) {
			return size - 1;
		}
		return size;
	}

	private String makeNamesJoiningDelimiter(List<String> names, String delimiter) {
		StringBuilder stringBuilder = new StringBuilder();

		for (int index = 0; index < names.size() - 1; ++index) {
			stringBuilder.append(names.get(index)).append(delimiter);
		}
		stringBuilder.append(names.get(names.size() - 1));

		return stringBuilder.toString();
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
