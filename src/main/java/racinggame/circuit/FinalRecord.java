package racinggame.circuit;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class FinalRecord {
	private final List<LapRecords> allRecords = new ArrayList<>();

	public void add(LapRecords lapRecords) {
		allRecords.add(lapRecords);
	}

	/**
	 * 실행결과를 출력하기 위한 출력물을 만든다.
	 * @return String
	 */
	public String readFinalRecord() {
		StringBuilder finalRecordBuilder = new StringBuilder();

		for (LapRecords record : allRecords) {
			finalRecordBuilder.append(record.read());
		}

		return finalRecordBuilder.toString();
	}

	/**
	 * 마지막 랩의 결과를 반환한다.
	 * 최종 우승자를 판별하기 위해 사용한다.
	 * @return {@link LapRecords}
	 */
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
