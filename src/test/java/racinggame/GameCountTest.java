package racinggame;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameCountTest {
	@Test
	@DisplayName("0보다 작거나 같은값이 입력되면 에러 반환")
	void createGameCountWithError() {
		assertThatThrownBy(() -> new GameCount(0)).hasMessageContaining("[ERROR] 0보다 큰 값을 입력해주세요")
			.isInstanceOf(IllegalArgumentException.class);
	}
}
