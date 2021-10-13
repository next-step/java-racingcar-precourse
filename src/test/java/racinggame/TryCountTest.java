package racinggame;

import static org.assertj.core.api.Assertions.*;
import static racinggame.common.ErrorMessage.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racinggame.domain.TryCount;

public class TryCountTest {

	TryCount tryCount;

	@Test
	void 시도_횟수_생성() {
		int count = 33;
		tryCount = new TryCount(count);
		assertThat(tryCount.getTryCount()).isEqualTo(count);
	}

	@Test
	void 시도_횟수_생성_문자열() {
		String countStr = "33";
		tryCount = new TryCount(countStr);
		assertThat(tryCount.getTryCount()).isEqualTo(Integer.parseInt(countStr));
	}

	@ParameterizedTest(name = "시도회수 생성 양수 검사 {0}")
	@ValueSource(ints = {0, -3})
	void 시도회수_숫자_생성_양수검사(int input) {
		assertThatThrownBy(() -> new TryCount(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(ERROR_TRY_COUNT);
	}

	@ParameterizedTest(name = "시도회수 생성 문자열 검사 {0}")
	@ValueSource(strings = {"a", "^", "0222", "01"})
	void 시도회수_문자열_생성_패턴검사(String input) {
		assertThatThrownBy(() -> new TryCount(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(ERROR_TRY_COUNT);
	}

}
