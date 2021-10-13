package racinggame.rule.winnerrules;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racinggame.circuit.FinalRecord;
import racinggame.circuit.LapRecords;
import racinggame.racingcar.LapRecord;
import racinggame.racingcar.Location;
import racinggame.common.RacingCarName;

class FarAwayWinRuleTest {
	private WinnerDecisionRule rule;

	@BeforeEach
	void beforeEach() {
		rule = new FarAwayWinRule();
	}

	@DisplayName("가장 멀린간 레이싱카를 우승자로 정한다.")
	@Test
	void winner() {
		//given
		WinnerNames winnerNames = new WinnerNames();
		winnerNames.addName("abc1");

		//when then
		assertThat(rule.judgeWinner(finalRecordWinner())).isEqualTo(winnerNames);
	}

	@DisplayName("우승자가 여러명인 경우, ',' 로 구분해 표시한다.")
	@Test
	void winners() {
		//given
		WinnerNames winnerNames = new WinnerNames();
		winnerNames.addName("abc1");
		winnerNames.addName("abc2");

		//when
		WinnerNames actualResult = rule.judgeWinner(finalRecordWinners());

		//then
		assertThat(actualResult).isEqualTo(winnerNames);
		assertThat(actualResult.getNamesWithDelimiter(",")).isEqualTo("abc1,abc2");
	}

	private FinalRecord finalRecordWinner() {
		FinalRecord finalRecord = new FinalRecord();

		LapRecords lapRecords = new LapRecords();
		lapRecords.add(new LapRecord(new RacingCarName("abc1"), new Location(3)));
		lapRecords.add(new LapRecord(new RacingCarName("abc2"), new Location(2)));

		finalRecord.add(lapRecords);

		return finalRecord;
	}

	private FinalRecord finalRecordWinners() {
		FinalRecord finalRecord = new FinalRecord();

		LapRecords lapRecords = new LapRecords();
		lapRecords.add(new LapRecord(new RacingCarName("abc1"), new Location(3)));
		lapRecords.add(new LapRecord(new RacingCarName("abc2"), new Location(3)));

		finalRecord.add(lapRecords);

		return finalRecord;
	}

}