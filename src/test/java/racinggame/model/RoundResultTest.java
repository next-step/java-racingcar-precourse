package racinggame.model;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RoundResultTest {
	private static final RoundResult ROUND_RESULT = new RoundResult(new StringBuilder());

	@DisplayName("roundResult가 차의 이동거리와 차의 이름을 포함하고있는지에 대한 테스트")
	@Test
	void appendRoundResult() {
		Car tom = new Car("tom");
		tom.move(CarAction.GO);
		tom.move(CarAction.GO);
		ROUND_RESULT.appendRoundResult(tom);
		assertThat(ROUND_RESULT.getRoundResultStr()).contains("tom : --");
	}
}