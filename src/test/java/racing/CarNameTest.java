package racing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {

	@DisplayName("자동차 이름이 5자 이하일 때 객체 생성 가능하다.")
	@ParameterizedTest
	@ValueSource(strings = {"pobi", "crong", "honux"})
	void 자동차_이름이_5자_이하일_때_객체_생성_가능하다(String name) {
		new CarName(name);
	}

	@DisplayName("자동차 이름이 6자 이상일 때 예외가 발생한다.")
	@ParameterizedTest
	@ValueSource(strings = {"y2o2u2n", "junseok"})
	void 자동차_이름이_6자_이상일_때_예외가_발생한다(String name) {
		assertThrows(IllegalArgumentException.class, () -> new CarName(name));
	}
}
