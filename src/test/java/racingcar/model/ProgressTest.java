package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class ProgressTest {
	private static final int PROGRESS_MIN = 0;

	@DisplayName("진행도 - 시작값")
	@Test
	void progress_begin() {
		Progress progress = Progress.begin();
		assertThat(progress).isNotNull();
		assertThat(progress.getValue()).isEqualTo(PROGRESS_MIN);
	}

	@DisplayName("진행도 - 특정값")
	@ParameterizedTest
	@ValueSource(ints = {0, 3, 6})
	void progress_actual_value(int num) {
		Progress progress = Progress.from(num);
		assertThat(progress).isNotNull();
		assertThat(progress.getValue()).isEqualTo(num);
	}

	@DisplayName("진행도 - 음수")
	@ParameterizedTest
	@ValueSource(ints = {-1, -3, -6})
	void progress_negative(int num) {
		assertThatThrownBy(() -> Progress.from(num))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("진행도 - 앞으로 한칸 이동")
	@ParameterizedTest
	@CsvSource(value = {"0:0", "1:0", "2:0", "3:0", "4:1", "5:1", "6:1", "7:1", "8:1", "9:1"}, delimiter = ':')
	void tryForward(int givenRandomResult, int expected) {
		Progress progress = Progress.begin();
		assertRandomNumberInRangeTest(
			() -> assertThat(progress.tryForward()).isEqualTo(Progress.from(expected))
			, givenRandomResult);
	}

	@DisplayName("진행도 - 진행바 노출")
	@ParameterizedTest
	@CsvSource(value = {"3:---", "5:-----", "0:''"}, delimiter = ':')
	void getProgressBar(int value, String expected) {
		Progress progress = Progress.from(value);
		assertThat(progress.getProgressBar()).isNotNull();
		assertThat(progress.getProgressBar()).isEqualTo(expected);
	}
}
