package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class GameRoundTest {
	@DisplayName("게임 진행 가능 여부 판단 할 수 있다")
	@ParameterizedTest(name = "남은 카운트가 {0}일 때, 진행 가능 판단 결과는 {1} 이다")
	@CsvSource(value = {"0,false", "1,true"})
	void given_value_then_decide_next_execution(String inputString, boolean expectedResult) {
		GameRound round = new GameRound(inputString);

		assertThat(round.hasNext()).isEqualTo(expectedResult);
	}

	@DisplayName("입력 값에 대한 예외 상황을 판단 할 수 있다")
	@ParameterizedTest(name = "입력 값이 {0}이면 예외가 발생한다.")
	@ValueSource(strings = {"a", "-1", ""})
	void given_invalid_value_then_throw_exception(String input) {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new GameRound(input))
			.withMessage("입력 값은 0 이상의 숫자여야 합니다.");
	}
}