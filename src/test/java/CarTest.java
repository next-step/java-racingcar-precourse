import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

	@ParameterizedTest
	@DisplayName("자동차 이름 검증")
	// @ValueSource(strings = {"", "123456"}) // 실패
	@ValueSource(strings = {"1", "12345"}) // 성공
	void isValidCarName(String carName) {
		assertThat(5 >= carName.length() && 1 <= carName.length())
			.withFailMessage("자동차 이름 검증실패= [" + carName + "]")
			// .isFalse(); // 실패
			.isTrue(); // 성공
	}

}
