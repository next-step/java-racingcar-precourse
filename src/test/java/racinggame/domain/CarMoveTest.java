package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarMoveTest {

	@Test
	@DisplayName("0~9사이의 값인지 검증")
	void zeroToNice() {
		new CarMove(0);
		new CarMove(9);

		assertThatThrownBy(() -> {
			CarMove carMove = new CarMove(-1);
		}).isInstanceOf(IllegalArgumentException.class).hasMessage(CarMove.ERROR_MESSAGE);
		assertThatThrownBy(() -> {
			CarMove carMove = new CarMove(10);
		}).isInstanceOf(IllegalArgumentException.class).hasMessage(CarMove.ERROR_MESSAGE);
	}
}
