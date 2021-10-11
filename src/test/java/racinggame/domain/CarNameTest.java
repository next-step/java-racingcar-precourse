package racinggame.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racinggame.exception.OutOfCarNameLengthException;

@DisplayName("자동차 이름 Test")
class CarNameTest {

	@Test
	@DisplayName("자동차 이름 길이 유효성 체크 테스트")
	void CarNameLengthTest() {
		assertThrows(OutOfCarNameLengthException.class, () -> {
			CarName carName = new CarName("람보르기니페라리");
		});
	}
}