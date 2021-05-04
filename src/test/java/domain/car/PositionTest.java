package domain.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

	@Test
	@DisplayName("포지션의 기본값은 1이다")
	void positionInit(){
		Integer defaultValue = 1;

		Position position = new Position();
		Integer value = position.getValue();

		assertThat(value).isEqualTo(defaultValue);
	}

	@Test
	@DisplayName("포지션의 값을 1씩 늘릴 수 있다.")
	void increment(){
		int expectedValue = 2;
		Position position = new Position();

		position.increment();

		assertThat(position.getValue()).isEqualTo(expectedValue);
	}

	@Test
	@DisplayName("기본값 보다 작은 값을 가질 수 없음")
	void minimalValue(){
		int value = 0;
		String message = "기본값 1 보다 작을 수 없습니다.";

		assertThatIllegalArgumentException()
			.isThrownBy(() -> new Position(value))
			.withMessage(message)
		;

	}
}
