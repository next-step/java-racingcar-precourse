package nextstep.test.utils;

import static org.mockito.ArgumentMatchers.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import nextstep.utils.Randoms;

class RandomsTest {
	@DisplayName("랜덤 결과가 5인것을 확인 한다.")
	@Test
	void given_two_number_then_check_range() {
		try (final MockedStatic<Randoms> mockRandoms = Mockito.mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(5);
			int number = Randoms.pickNumberInRange(0, 9);
			Assertions.assertThat(number).isEqualTo(5);
		}
	}

	@DisplayName("끝값의 범위 초과 예외를 확인한다.")
	@Test
	void when_end_value_is_max_then_throw_exception() {
		Assertions.assertThatIllegalArgumentException()
			.isThrownBy(() -> Randoms.pickNumberInRange(0, Integer.MAX_VALUE))
			.withMessage("끝값이 너무 큽니다. (스택 오버플로우 발생이 가능합니다)");
	}

	@DisplayName("끝값보다 첫번째 값이 큰 경우 예외를 확인한다.")
	@Test
	void when_start_greater_than_end_then_throw_exception() {
		Assertions.assertThatIllegalArgumentException()
			.isThrownBy(() -> Randoms.pickNumberInRange(9, 0))
			.withMessage("startInclusive가 endInclusive보다 클 수 없습니다.");
	}

	@DisplayName("입력 값이 너무 큰 경우 예외를 발생한다.")
	@Test
	void when_too_large_value_then_throw_exception() {
		Assertions.assertThatIllegalArgumentException()
			.isThrownBy(() -> Randoms.pickNumberInRange(1, Integer.MAX_VALUE + 1))
			.withMessage("입력값이 너무 큽니다.");
	}
}