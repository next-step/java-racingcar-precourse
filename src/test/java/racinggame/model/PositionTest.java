package racinggame.model;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {
	@DisplayName("move 메서드를 호출했을때 포지션이 증가하는지 테스트")
	@Test
	void move() {
		Position position = new Position();
		position.move();
		assertThat(position.getPosition()).isEqualTo(1);
	}
}