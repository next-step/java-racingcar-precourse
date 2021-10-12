package racinggame.circuit;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racinggame.racingcar.LapRecord;
import racinggame.racingcar.Location;
import racinggame.common.Name;

class FinalRecordTest {

	private FinalRecord finalRecord;

	@DisplayName("1랩 결과를 출력한다.")
	@Test
	void printResult() {
		//given
		finalRecord = new FinalRecord();
		finalRecord.add(lapRecord());

		String expected = new StringBuilder()
			.append("abc1 : -\n")
			.append("abc2 : --\n")
			.toString();

		//when then
		assertThat(finalRecord.readFinalRecord()).contains(expected);
	}

	@DisplayName("2랩 결과를 출력한다.")
	@Test
	void print2LapResult() {
		//given
		finalRecord = lapRecords();

		String expected = new StringBuilder()
			.append("abc1 : -\n")
			.append("abc2 : --\n")
			.append("\n")
			.append("abc1 : -\n")
			.append("abc2 : --\n")
			.toString();

		//when then
		assertThat(finalRecord.readFinalRecord()).contains(expected);
	}

	private LapRecords lapRecord() {
		LapRecords lapRecords = new LapRecords();
		lapRecords.add(new LapRecord(new Name("abc1"), new Location(1)));
		lapRecords.add(new LapRecord(new Name("abc2"), new Location(2)));

		return lapRecords;
	}

	private FinalRecord lapRecords() {
		FinalRecord finalRecord = new FinalRecord();

		finalRecord.add(lapRecord());
		finalRecord.add(lapRecord());

		return finalRecord;
	}
}
