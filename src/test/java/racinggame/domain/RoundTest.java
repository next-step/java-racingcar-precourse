package racinggame.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racinggame.domain.boxing.Round;
import racinggame.error.ErrorMessage;
import racinggame.error.InvalidGameRoundInput;

public class RoundTest {

	@DisplayName("Round 생성 Test")
	@Test
	void roundValidateTest() {
		assertThatThrownBy(() -> new Round("abc"))
			.isInstanceOf(InvalidGameRoundInput.class)
			.hasMessageContaining(ErrorMessage.INVALID_GAME_ROUND_INPUT);
	}
}
