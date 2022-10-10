package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameListTest {
	@DisplayName("자동차 이름 문자열 입력")
	@ParameterizedTest
	@CsvSource(value = {"abc:1", "abc,def,ghi:3", "abc,def,ghi,jkl,mno:5"}, delimiter = ':')
	void carNameList(String input, int expected) {
		CarNameList carNameList = CarNameList.from(input);
		assertThat(carNameList).isNotNull();
		assertThat(carNameList.getList()).hasSize(expected);
	}

	@DisplayName("자동차 이름 문자열 입력 - 빈 목록")
	@ParameterizedTest
	@ValueSource(strings = {"", "  ", "      "})
	void carNameList_empty_list(String input) {
		assertThatThrownBy(() -> CarNameList.from(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("경주할 자동차 이름을 입력해 주세요.");
	}

	@DisplayName("자동차 이름 문자열 입력 - 쉼표로 종료시, 마지막 쉼표 무시")
	@ParameterizedTest
	@CsvSource(value = {"abc,def,:2", "abc,edf,hij,:3"}, delimiter = ':')
	void carNameList_end_with_comma(String input, int expected) {
		CarNameList carNameList = CarNameList.from(input);
		assertThat(carNameList).isNotNull();
		assertThat(carNameList.getList()).hasSize(expected);
	}

	@DisplayName("자동차 이름 문자열 입력 - 쉼표만 존재시, 빈 입력으로 취급")
	@ParameterizedTest
	@ValueSource(strings = {",", ",,", ",,,,,"})
	void carNameList_only_comma(String input) {
		assertThatThrownBy(() -> CarNameList.from(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("경주할 자동차 이름을 입력해 주세요.");
	}

	@DisplayName("자동차 이름 문자열 입력 - 쉼표로 시작시, 첫번째 이름 공백 입력으로 취급")
	@ParameterizedTest
	@ValueSource(strings = {",abc", ",def,ghi"})
	void carNameList_start_with_comma(String input) {
		assertThatThrownBy(() -> CarNameList.from(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("자동차 이름이 공백일 수는 없습니다.");
	}
}