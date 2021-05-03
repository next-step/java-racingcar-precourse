import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class GameNumberTest {
	@Test
	void 특정_범위_안의_숫자를_가짐() {
		GameNumber gameNumber = new GameNumber();
		assertThat(gameNumber.isValid(0)).isTrue();
		assertThat(gameNumber.isValid(9)).isTrue();
		assertThat(gameNumber.isValid(-1)).isFalse();
		assertThat(gameNumber.isValid(10)).isFalse();
	}

	@RepeatedTest(1000)
	void 정해진_범위_안의_숫자를_생성() {
		GameNumber gameNumber = new GameNumber();
		int no = gameNumber.generate();
		assertThat(gameNumber.isValid(no)).isTrue();
	}

	@RepeatedTest(1000)
	void 객체_생성시_정해진_범위_안의_숫자를_생성() {
		GameNumber gameNumber = new GameNumber();
		assertThat(gameNumber.isValid(gameNumber.getNumber())).isTrue();
	}
}
