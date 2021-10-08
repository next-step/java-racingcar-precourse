package racinggame.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TryCountTest {

	@Test
	@DisplayName("레이스 시도횟수를 생성한다.")
	public void createCount() {
		TryCount tryCount = new TryCount(2);

		assertThat(tryCount).isEqualTo(new TryCount(2));
	}

	@Test
	@DisplayName("레이스 시도횟수가 0이하 이면 예외가 발생한다.")
	public void checkMinCount() {
		assertThrows(IllegalArgumentException.class,
			() -> new TryCount(0));
	}

	@ParameterizedTest
	@DisplayName("레이스 시도횟수가 숫자가 아니면 예외가 발생한다.")
	@CsvSource(value = {"1Ab", "12!", "1ㄱㅁㅍ"})
	public void checkMatchType(String tryCount) {
		assertThrows(IllegalArgumentException.class,
			() -> new TryCount(tryCount));
	}

	@Test
	@DisplayName("레이스 시도횟수가 빈값이면 예외가 발생한다.")
	public void checkEmpty() {
		assertThrows(IllegalArgumentException.class,
			() -> new TryCount(""));
	}

	@Test
	@DisplayName("레이스 시도횟수가 null 이면 예외가 발생한다.")
	public void checkNull() {
		assertThrows(IllegalArgumentException.class,
			() -> new TryCount(null));
	}

	@Test
	@DisplayName("레이스는 한번 진행시 1씩 증가된다.")
	public void tryRacing() {
		TryCount tryCount = new TryCount(3);
		Assertions.assertAll(
			() -> assertThat(tryCount.tryRacing()).isEqualTo(1),
			() -> assertThat(tryCount.tryRacing()).isEqualTo(2),
			() -> assertThat(tryCount.tryRacing()).isEqualTo(3)
		);
	}

	@Test
	@DisplayName("레이스의 횟수에 따라 종료 여부를 알 수 있다.")
	public void isFinish() {
		TryCount tryCount = new TryCount(3);
		Assertions.assertAll(
			() -> {
				tryCount.tryRacing();
				assertThat(tryCount.isNotFinish()).isTrue();
			},
			() -> {
				tryCount.tryRacing();
				assertThat(tryCount.isNotFinish()).isTrue();
			},
			() -> {
				tryCount.tryRacing();
				assertThat(tryCount.isNotFinish()).isFalse();
			}
		);
	}

}