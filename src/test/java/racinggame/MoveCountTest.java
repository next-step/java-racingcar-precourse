package racinggame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoveCountTest {

	@Test
	@DisplayName("사용자 입력(이동횟수)이 음수인가?")
	void 이동횟수_입력_음수검증() {
		assertThatThrownBy(() -> {
			new MoveCount("-1");
		}).isInstanceOf(IllegalArgumentException.class).hasMessage(MoveCount.ERROR_MESSAGE);
	}

	@Test
	@DisplayName("사용자 입력(이동횟수)이 공백인가?")
	void 이동횟수_입력_공백검증() {
		assertThatThrownBy(() -> {
			new MoveCount("");
		}).isInstanceOf(IllegalArgumentException.class).hasMessage(MoveCount.ERROR_MESSAGE);
	}

	@Test
	@DisplayName("사용자 입력(이동횟수)이 숫자인가?")
	void 이동횟수_입력_숫자검증() {
		new MoveCount("1");
		assertThatThrownBy(() -> {
			new MoveCount("a");
		}).isInstanceOf(IllegalArgumentException.class).hasMessage(MoveCount.ERROR_MESSAGE);
	}
}
