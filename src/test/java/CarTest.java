import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

	// 자동차 이름 검증
	boolean isValidCarName(String carName) {
		return 5 >= carName.length() && 1 <= carName.length();
	}

	// 자동차 대수 검증
	boolean isValidCarCount(String[] carNameArr) {
		return 2 <= carNameArr.length;
	}

	// 자동차 이름 목록 검증
	boolean isValidCarNames(String[] carNameArr) {
		int loopCount = 0;
		boolean validCarNameResult = true;
		while (loopCount < carNameArr.length && validCarNameResult) {
			validCarNameResult = isValidCarName(carNameArr[loopCount]);
			loopCount++;
		}
		return loopCount == carNameArr.length && validCarNameResult;
	}

	@ParameterizedTest
	@DisplayName("사용자 입력 자동차 이름들 검증")
	@ValueSource(strings = {"1,2", "1,2,3,4"}) // 성공
	void isValidCar(String carNames) {
		boolean testResult = false;
		String[] carNameArr = carNames.split(",");

		if (!isValidCarCount(carNameArr)) {
			assertThat(testResult).withFailMessage("자동차 대수 검증실패= " + carNames)
				// .isTrue();
				.isFalse();
		}

		testResult = isValidCarNames(carNameArr); // 자동차 이름 목록 검증
		assertThat(testResult).withFailMessage("사용자 입력 자동차 이름들 검증실패= " + carNames)
			.isTrue();
			// .isFalse();
	}

}
