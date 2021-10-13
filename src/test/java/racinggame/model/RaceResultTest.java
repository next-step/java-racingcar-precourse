package racinggame.model;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceResultTest {
	private static final RaceResult RACE_RESULT = new RaceResult();
	private static final String SOMETHING_MESSAGE = "something message";

	@DisplayName("RaceResult가 append한 문자열과 결과메세지에 포함되어야 할 문자열을 포함하고 있는지에 대한 테스트")
	@Test
	void appendRoundResult() {
		RACE_RESULT.appendRoundResult(SOMETHING_MESSAGE);
		assertThat(RACE_RESULT.getRaceResult()).contains("실행 결과", SOMETHING_MESSAGE);
	}
}