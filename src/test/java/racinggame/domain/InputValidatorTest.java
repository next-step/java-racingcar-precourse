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
		@DisplayName("자동차 이름이 입력되면")
		class ContextCarNameInput {

			@ParameterizedTest
			@ValueSource(strings = {"car1", "car1, car2", "car1, car2, car3"})
			@DisplayName("exception 발생시키지 않는다")
			void it_valid_input(String input) {
				sut.validCarName(input);
			}
		}

		@Nested
		@DisplayName("빈 문자열이 입력된 경우")
		class ContextEmptyInput {

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

	@Nested
	@DisplayName("validTryNumber 메소드는")
	class DescribeValidTryNumber {

		@Nested
		@DisplayName("1이상의 숫자가 입력되면")
		class ContextGreaterThenOne {

			@ParameterizedTest
			@ValueSource(strings = {"1", "2" , "10", "20"})
			@DisplayName("exception 발생시키지 않는다")
			void it_valid_input(String input) {
				sut.validTryNumber(input);
			}
		}

		@Nested
		@DisplayName("빈 문자열이 입력된 경우")
		class ContextEmptyInput {

			final String input = "";

			@Test
			@DisplayName("IllegalArgumentException 발생시킨다")
			void it_throw_exception() {
				assertThatThrownBy(() -> sut.validTryNumber(input))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessageContaining("[ERROR]");
			}
		}

		@Nested
		@DisplayName("문자가 입력된 경우")
		class ContextCharacterInput {

			@ParameterizedTest
			@ValueSource(strings = {"abc", "1bc", "a1c", "ab1"})
			@DisplayName("IllegalArgumentException 발생시킨다")
			void it_throw_exception(String input) {
				assertThatThrownBy(() -> sut.validTryNumber(input))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessageContaining("[ERROR]");
			}
		}

		@Nested
		@DisplayName("1보다 작은 숫자가 입력된 경우")
		class ContextLessThenOne {

			@ParameterizedTest
			@ValueSource(strings = {"0", "-1", "-2"})
			@DisplayName("IllegalArgumentException 발생시킨다")
			void it_throw_exception(String input) {
				assertThatThrownBy(() -> sut.validTryNumber(input))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessageContaining("[ERROR]");
			}
		}
	}
}
