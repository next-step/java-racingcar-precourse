package racinggame;

import static org.assertj.core.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import racinggame.model.TryNumber;

public class TryNumberTest {

	@ParameterizedTest
	@CsvSource(value = {"0", "1"})
	void TryNumber_생성_테스트(int givenTryNumber) {
		TryNumber tryNumber = TryNumber.of(givenTryNumber);

		assertThat(tryNumber.getNumber()).isEqualTo(givenTryNumber);
	}

	@CsvSource(value = {"0,0", "1,1"})
	void TryNumber_생성_테스트2(String givenTryNumber, int expectedTryNumber) {
		Optional<TryNumber> tryNumber = TryNumber.of(givenTryNumber);

		assertThat(tryNumber.isPresent()).isEqualTo(true);
		assertThat(tryNumber.get().getNumber()).isEqualTo(expectedTryNumber);
	}

	@ParameterizedTest
	@CsvSource(value = {"0,false", "1,true", "5,true"})
	void TryNumber_유효성_테스트(int givenTryNumber, boolean expected) {
		TryNumber tryNumber = TryNumber.of(givenTryNumber);

		assertThat(tryNumber.isValid()).isEqualTo(expected);
	}
}
