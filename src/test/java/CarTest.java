import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

	boolean isValidCarName(String carName) {
		return 5 >= carName.length() && 1 <= carName.length();
	}

	@ParameterizedTest
	@DisplayName("자동차 대수 검증")
	// @ValueSource(strings = {"1", "1,", ",1", ",", ""}) // 실패
	@ValueSource(strings = {"1,2", "1,2,3,4,5"}) // 성공
	void isValidCarCount(String carNameArr) {
		assertThat(2 <= carNameArr.split(",").length)
			.withFailMessage("자동차 대수 검증실패= [" + carNameArr + "]")
			// .isFalse(); // 실패
			.isTrue(); // 성공
	}

	@ParameterizedTest
	@DisplayName("자동차 이름 목록 검증")
	// @ValueSource(strings = {"1,123456"}) // 실패
	@ValueSource(strings = {"1", "1,12345"}) // 성공
	void isValidCarNames(String carNames) {
		String[] carNameArr = carNames.split(",");
		int loopCount = 0;
		boolean validCarNameResult = false;
		while (loopCount < carNameArr.length && !validCarNameResult) {
			validCarNameResult = isValidCarName(carNameArr[loopCount]);
			loopCount++;
		}
		validCarNameResult = loopCount == carNameArr.length && validCarNameResult;
		assertThat(validCarNameResult)
			.withFailMessage("자동차 이름 목록 검증실패=" + Arrays.toString(carNameArr))
			// .isFalse(); // 실패
			.isTrue(); // 성공
	}

}
