package racinggame;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarMoveTest {

	@Test
	@DisplayName("0~9사이의 값인지 검증")
	void zeroToNice() {
		Assertions.assertThatThrownBy(() ->{
			CarMove carMove = new CarMove(10);
		}).isInstanceOf(IllegalArgumentException.class);
	}
}
