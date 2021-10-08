package racinggame.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

}