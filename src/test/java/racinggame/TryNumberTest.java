package racinggame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TryNumberTest {

	@ParameterizedTest
	@CsvSource(value = {"0", "1"})
	void TryNumber_생성_테스트(int givenTryNumber) {
		TryNumber tryNumber = new TryNumber(givenTryNumber);

		assertThat(tryNumber.getNumber()).isEqualTo(givenTryNumber);
	}

	@ParameterizedTest
	@CsvSource(value = {"0,false", "1,true", "5,true"})
	void TryNumber_유효성_테스트(int givenTryNumber, boolean expected) {
		TryNumber tryNumber = new TryNumber(givenTryNumber);

		assertThat(tryNumber.isValid()).isEqualTo(expected);
	}
}
