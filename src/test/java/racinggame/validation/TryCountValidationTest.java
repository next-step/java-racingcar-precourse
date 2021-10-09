package racinggame.validation;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TryCountValidationTest {

	@Test
	@DisplayName("입력받는 레이싱횟수의 상태체크를 생성한다.")
	public void createTryCountValidation() {
		TryCountValidation tryCountValidation = new TryCountValidation();

		assertThat(tryCountValidation).isEqualTo(new TryCountValidation());
	}

	@Test
	@DisplayName("입력받은 횟수가 null 이면 error 상태는 true 이다.")
	public void checkNull() {
		TryCountValidation tryCountValidation = new TryCountValidation();

		TryCountValidation result = tryCountValidation.checkInputStatus(null);
		assertThat(result.isProblem()).isTrue();
	}

	@Test
	@DisplayName("입력받은 횟수가 빈값 이면 error 상태는 true 이다.")
	public void checkEmpty() {
		TryCountValidation tryCountValidation = new TryCountValidation();

		TryCountValidation result = tryCountValidation.checkInputStatus("");
		assertThat(result.isProblem()).isTrue();
	}

	@Test
	@DisplayName("입력받는 횟수가 0이하이면 error 상태는 true 이다.")
	public void isSuitableSize() {
		TryCountValidation tryCountValidation = new TryCountValidation();

		TryCountValidation result = tryCountValidation.checkInputStatus("0");
		assertThat(result.isProblem()).isTrue();
	}

	@ParameterizedTest
	@DisplayName("입력받는 횟수가 숫자타입이 아니면 error 상태는 true 이다.")
	@CsvSource(value = {"1Ab", "12!", "1ㄱㅁㅍ"})
	public void isMatchType(String tryCount) {
		TryCountValidation tryCountValidation = new TryCountValidation();

		TryCountValidation result = tryCountValidation.checkInputStatus(tryCount);
		assertThat(result.isProblem()).isTrue();
	}

}