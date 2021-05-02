import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GamePlayServiceTest {

	// 숫자인지 검증
	boolean isNumber(String randomValue) {
		try {
			return isAboveMinimum(Integer.parseInt(randomValue));
		} catch (NumberFormatException e) {
			System.out.println("숫자를 입력해 주세요.");
			return false;
		}
	}

	// 1 이상인지 검증
	boolean isAboveMinimum(int playCount) {
		if (1 > playCount) {
			System.out.println("1이상의 숫자를 입력해 주세요.");
			return false;
		}
		return true;
	}

	@ParameterizedTest
	@ValueSource(strings = {"-14234", "0", "a", "ㅁ"}) // 실패
	// @ValueSource(strings = {"1", "12351"}) // 성공
	void getRaceCount(String randomValue) {
		assertThat(isNumber(randomValue))
			.withFailMessage("숫자 검증 실패= " + randomValue)
			.isFalse();  // 실패
			// .isTrue(); // 성공
	}

}
