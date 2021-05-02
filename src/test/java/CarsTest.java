import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarsTest {

	// 자동차 이름 목록 검증
	boolean isValidCarNames(String[] carNameArr) {
		int loopCount = 0;
		boolean validCarNameResult = true;
		while (loopCount < carNameArr.length && validCarNameResult) {
			validCarNameResult = CarTest.isValidCarName(carNameArr[loopCount]);
			loopCount++;
		}
		return loopCount == carNameArr.length && validCarNameResult;
	}

	// 사용자 입력 자동차 이름들 검증
	boolean isValidCar(String[] carNameArr) {
		if (!CarTest.isValidCarCount(carNameArr)) {
			return false;
		}
		return isValidCarNames(carNameArr);
	}

	@ParameterizedTest
	@DisplayName("자동차 이름 얻기")
	@ValueSource(strings = {"1,2", "1,2,3,4"}) // 성공
		// @ValueSource(strings = {"", "1,", ",1", ",,"}) // 실패
	void getCarNames(String carNames) {
		String[] carNameArr = carNames.split(",");
		assertThat(isValidCar(carNameArr))
			.withFailMessage("자동차 이름 얻기 실패= " + carNames)
			.isTrue(); // 성공
		// .isFalse(); // 실패
	}

}
