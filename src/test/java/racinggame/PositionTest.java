package racinggame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionTest {

	@Test
	@DisplayName("위치 이동")
	void moveTest() {
		TestPosition position = new TestPosition();
		position.move(() -> true);
		position.move(() -> false);
		assertThat(position).isEqualTo(new TestPosition(1));
	}

	private class TestPosition extends Position {

		public TestPosition() {
			super();
		}

		public TestPosition(int position) {
			this.position = position;
		}
	}

}
