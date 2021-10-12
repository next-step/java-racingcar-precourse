package racinggame.ui;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racinggame.exception.InvalidNameException;
import racinggame.racingcar.Name;

class NamesTest {
	@DisplayName("이미 입력한 이름을 추가하면 예외 발생한다.")
	@Test
	void addFailed() {
		//given
		String name = "abc";

		Names names = new Names();
		names.add(new Name(name));

		//when then
		assertThatThrownBy(() -> names.add(new Name(name)))
			.isInstanceOf(InvalidNameException.class)
			.hasMessage("[ERROR] 중복된 이름을 사용할 수 없습니다.");
	}
}