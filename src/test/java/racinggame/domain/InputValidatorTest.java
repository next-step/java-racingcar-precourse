package racinggame.domain;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("InputValidator 클래스")
class InputValidatorTest {

	final InputValidator sut = new InputValidator();

	@Nested
	@DisplayName("validCarName 메소드는")
	class DescribeValidCarName {

		@Nested
		@DisplayName("빈 문자열이 입력된 경우")
		class ContextEmptyString {

			final String input = "";

			@Test
			@DisplayName("IllegalArgumentException 발생시킨다")
			void it_throw_exception() {
				assertThatThrownBy(() -> sut.validCarName(input))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessageContaining("[ERROR]");
			}
		}

		@Nested
		@DisplayName("전달받은 자동차 이름 중 빈 문자열이 있으면")
		class ContextEmptyCarName {

			@ParameterizedTest
			@ValueSource(strings = {"car1,,car2", ",car1,car2", "car1,car2,", "car,,", ",car,", ",,car", ",,"})
			@DisplayName("IllegalArgumentException 발생시킨다")
			void it_throw_exception(String input) {
				assertThatThrownBy(() -> sut.validCarName(input))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessageContaining("[ERROR]");
			}
		}
	}
}
