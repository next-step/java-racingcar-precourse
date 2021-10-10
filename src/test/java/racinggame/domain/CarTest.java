package racinggame.domain;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import nextstep.utils.Randoms;

@DisplayName("Car 클래스")
class CarTest {

	final Car sut = new Car("car");

	@Nested
	@DisplayName("drive 메소드는")
	class DescribeDrive {

		@Nested
		@DisplayName("랜덤으로 만든 숫자가 3보다 큰 경우")
		class ContextGreaterThenThree {

			@ParameterizedTest(name = "[{index}] 랜덤숫자: {0}")
			@ValueSource(ints = {4, 5, 6})
			@DisplayName("Distance 값을 1 증가시킨다")
			void it_increase_distance(int randomNumber) {
				try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
					mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
						.thenReturn(randomNumber);
					int prev = sut.getDistance().getValue();
					sut.drive();
					int cur = sut.getDistance().getValue();

					Assertions.assertThat((cur - prev)).isEqualTo(1);
				}
			}
		}

		@Nested
		@DisplayName("랜덤으로 만든 숫자가 4보다 작은 경우")
		class ContextLessThenFour {

			@ParameterizedTest(name = "[{index}] 랜덤숫자: {0}")
			@ValueSource(ints = {3, 2, 1})
			@DisplayName("Distance 값을 증가시키지 않는다")
			void it_increase_distance(int randomNumber) {
				try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
					mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
						.thenReturn(randomNumber);
					int prev = sut.getDistance().getValue();
					sut.drive();
					int cur = sut.getDistance().getValue();

					Assertions.assertThat((cur - prev)).isEqualTo(0);
				}
			}
		}
	}
}
