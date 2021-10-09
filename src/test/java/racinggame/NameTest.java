package racinggame;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class NameTest {

	@ParameterizedTest
	@MethodSource("provideNamesWithLongLength")
	@DisplayName("이름 예외처리")
	void nameExceptionTest(String name, String message) {
		assertThatIllegalArgumentException().isThrownBy(() -> new TestName(name)).withMessage(message);
	}

	@Test
	@DisplayName("이름 정상처리")
	void nameTest() {
		String name = "페라리";
		TestName testName = new TestName(name);
		assertThat(testName).isEqualTo(new TestName(name));
	}

	private static Stream<Arguments> provideNamesWithLongLength() {
		return Stream.of(
			Arguments.of("자동차123", TestName.OUT_OF_LENGTH_MESSAGE),
			Arguments.of("123456", TestName.OUT_OF_LENGTH_MESSAGE),
			Arguments.of("", TestName.MUST_BE_NOT_EMPTY),
			Arguments.of(null, TestName.MUST_BE_NOT_EMPTY));

	}

	//Name 클래스의 protected 상수 변수에 접근하기 위해 TestName 클래스 사용
	private class TestName extends Name {
		private TestName(String name) {
			super(name);
		}
	}

}
