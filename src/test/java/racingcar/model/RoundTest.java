package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RoundTest {
	@DisplayName("차수별 진행 - 첫 라운드")
	@Test
	void start() {
		CarNameList carNameList = givenCarNameList();
		Round round = Round.start(carNameList);
		assertThat(round).isNotNull();
		assertThat(round.getCarNameProgress()).isNotEmpty();
		round.getCarNameProgress()
			.forEach((carName, progress) ->
				assertThat(progress).isEqualTo(Progress.begin()));
	}

	@DisplayName("차수별 진행 - 다음 라운드")
	@ParameterizedTest
	@CsvSource(value = {"0:0", "1:0", "2:0", "3:0", "4:1", "5:1", "6:1", "7:1", "8:1", "9:1"}, delimiter = ':')
	void next(int givenRandomResult, int diff) {
		CarNameList carNameList = givenCarNameList();
		Round prevRound = Round.start(carNameList);
		Map<CarName, Progress> prevRoundCarNameProgress = prevRound.getCarNameProgress();

		assertRandomNumberInRangeTest(
			() -> {
				Round nextRound = prevRound.next(carNameList);
				assertThat(nextRound).isNotNull();
				assertThat(nextRound.getCarNameProgress()).isNotEmpty();
				nextRound.getCarNameProgress()
					.forEach((carName, nowProgress) -> {
						Progress prevProgress = prevRoundCarNameProgress.get(carName);
						assertThat(nowProgress.getValue() - prevProgress.getValue()).isEqualTo(diff);
					});
			}
			, givenRandomResult);
	}

	private CarNameList givenCarNameList() {
		return CarNameList.from("abc,def,ghi");
	}
}