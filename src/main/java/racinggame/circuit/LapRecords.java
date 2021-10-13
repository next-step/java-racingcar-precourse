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

	/**
	 * 한 랩의 모든 레이싱카 기록을 문자열로 반환한다.
	 * 랩과 랩 사이에 개행을 넣어 랩을 구별한다.
	 *
	 * @return String
	 */
	public String read() {
		StringBuilder lapRecordBuilder = new StringBuilder();

		for (LapRecord record : lapRecords) {
			lapRecordBuilder.append(record.read());
		}
		lapRecordBuilder.append("\n");

		return lapRecordBuilder.toString();
	}

	public List<LapRecord> getLapRecords() {
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
