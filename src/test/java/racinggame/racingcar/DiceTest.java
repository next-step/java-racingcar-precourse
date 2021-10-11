package racinggame.racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racinggame.exception.InvalidDiceException;

class DiceTest {

	@DisplayName("주사위 생성 성공")
	@Test
	void dice() {
		assertThatNoException().isThrownBy(() -> new Dice(0, 9));
	}

	@DisplayName("에러발생 - 최솟값이 최댓값보다 크다")
	@Test
	void diceFailed() {
		assertThatThrownBy(() -> new Dice(9, 0))
			.isInstanceOf(InvalidDiceException.class)
			.hasMessage("주사위 최솟값은 최댓값보다 작은 값으로 설정해야 합니다.");
	}

}