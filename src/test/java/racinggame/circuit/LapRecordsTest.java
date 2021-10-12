package racinggame.circuit;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racinggame.racingcar.LapRecord;
import racinggame.racingcar.Location;
import racinggame.racingcar.Name;

class LapRecordsTest {

	@DisplayName("랩 결과를 출력한다.")
	@Test
	void printLapResult() {
		//given
		LapRecords lapRecords = lapRecords();
		String expectedResult = new StringBuilder()
			.append("abc1 : \n")
			.append("abc2 : -\n\n")
			.toString();

		//when then
		assertThat(lapRecords.read()).isEqualTo(expectedResult);
	}

	private LapRecords lapRecords() {
		LapRecords lapRecords = new LapRecords();

		lapRecords.add(new LapRecord(new Name("abc1"), new Location(0)));
		lapRecords.add(new LapRecord(new Name("abc2"), new Location(1)));

		return lapRecords;
	}
}
