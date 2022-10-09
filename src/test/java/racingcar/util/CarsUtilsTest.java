package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarsUtilsTest {

	@ParameterizedTest(name = "각 자동차 이름이 빈값이 아니며 5자 이하인 경우 True 반환한다. 이름: {argumentsWithNames}")
	@ValueSource(strings = {"c,c", "c,crong", "crong,crong"})
	void validateCarNames(String names) {
		assertThat(CarsUtils.validateCarNames(names)).isTrue();
	}

	@ParameterizedTest(name = "자동차들 중 하나라도 이름이 빈값이거나 5자 초과시 False 반환한다. 이름: {argumentsWithNames}")
	@ValueSource(strings = {",", ",c", " ,c", "c,123456", "123456,c"})
	void validateCarNames_FalseByWrongNames(String names) {
		assertThat(CarsUtils.validateCarNames(names)).isFalse();
	}

	@ParameterizedTest(name = "빈값이 아니며 5자 이하인 이름인 경우 True 를 반환 한다.")
	@ValueSource(strings = {"c", "crong"})
	void validateCarName(String name) {
		assertThat(CarsUtils.validateCarName(name)).isTrue();
	}

	@ParameterizedTest(name = "자동차 이름이 빈값이거나 5자 초과시 False 반환한다. 이름: {argumentsWithNames}")
	@ValueSource(strings = {" ", "", "123456"})
	void validateCarName_FalseByWrongName(String name) {
		assertThat(CarsUtils.validateCarName(name)).isFalse();
	}

	@Test
	void validateTryNo() {
		assertThat(CarsUtils.validateTryNo("1")).isTrue();
	}

	@ParameterizedTest(name = "숫자가 아니거나 0 초과가 아닐시 False 반환한다. 시도 횟수: {argumentsWithNames}")
	@ValueSource(strings = {"", "a", "0"})
	void validateTryNo_FalseByWrongTryNo(String tryNo) {
		assertThat(CarsUtils.validateTryNo(tryNo)).isFalse();
	}
}