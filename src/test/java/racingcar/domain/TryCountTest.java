package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TryCountTest {
	@DisplayName("이동 횟수를 생성한다")
	@Test
	void createTest() {
		assertThat(new TryCount("1")).isNotNull();
	}

	@DisplayName("이동 횟수는 숫자만 입력 가능")
	@Test
	void notNumberTest() {
		assertThatThrownBy(() -> new TryCount("a"))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("이동 횟수는 0보다 큰 숫자여야 한다")
	@Test
	void over0Test() {
		assertThatThrownBy(() -> new TryCount("0"))
				.isInstanceOf(IllegalArgumentException.class);
		assertThat(new TryCount("1")).isNotNull();
	}

	@DisplayName("시도 횟수만큼 함수를 실행할 수 있다")
	@Test
	void runTest() {
		AtomicInteger number = new AtomicInteger(0);
		new TryCount("5").run(number::getAndIncrement);
		assertThat(number.get()).isEqualTo(5);
	}
}
