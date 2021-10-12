package racinggame.racinggame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racinggame.common.RacingCarName;
import racinggame.exception.InvalidNameException;

class RacingCarNamesTest {
	@DisplayName("이미 입력한 이름을 추가하면 예외 발생한다.")
	@Test
	void addFailed() {
		//given
		String name = "abc";

		RacingCarNames racingCarNames = new RacingCarNames();
		racingCarNames.add(new RacingCarName(name));

		//when then
		assertThatThrownBy(() -> racingCarNames.add(new RacingCarName(name)))
			.isInstanceOf(InvalidNameException.class)
			.hasMessage("[ERROR] 중복된 이름을 사용할 수 없습니다.");
	}
}