package domain.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
	@DisplayName("기본값 보다 작은 값을 가질 수 없음")
	void minimalValue(){
		int value = 0;
		String message = "기본값 1 보다 작을 수 없습니다.";

		assertThatIllegalArgumentException()
			.isThrownBy(() -> new Position(value))
			.withMessage(message)
		;
	}

	@ParameterizedTest
	@DisplayName("포지션끼리 비교가 되야함")
	@CsvSource(value = {"1:1:true", "1:2:false"}, delimiter = ':')
	void comparison(int firstValue, int secondValue, boolean expected){
		Position firstPosition = new Position(firstValue);
		Position secondPosition = new Position(secondValue);

		assertThat(firstPosition.equals(secondPosition)).isEqualTo(expected);
	}

}
