package utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ValidationTest {

	@ParameterizedTest
	@DisplayName("자동차 이름의 길이가 1 ~ 5 사이인지 검증한다")
	void isValidCarNameTest() {
		String carName = "gjenfwo";
		boolean expectedResult = false;
		assertThat(Validation.isValidCarNameLength(carName)).isEqualTo(expectedResult);
	}

	@ParameterizedTest
	@CsvSource(value = {"tesla,toyota,bmw,audi:true", "tesla,toyota,bmw,tesla:false"}, delimiter = ':')
	@DisplayName("중복된 자동차 이름이 있는지 검증한다")
	void isDuplicateCarNameExistsTest(String CarNames, boolean expectedResult) {
		// given
		String[] splits = CarNames.split(",");

		// then
		assertThat(Validation.isDuplicateCarNameExists(splits)).isEqualTo(expectedResult);
	}

	@ParameterizedTest
	@CsvSource(value = {"1.5,false", "2,true"})
	@DisplayName("시도 횟수가 1 이상의 정수  자연수인지 검증한다")
	void validateRoundCountTest(String roundCount, boolean expectedResult) {
		// then
		assertThat(Validation.validateRoundCount(roundCount)).isEqualTo(expectedResult);
	}
}
