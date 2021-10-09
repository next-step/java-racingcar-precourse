package racinggame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionTest {

	@Test
	@DisplayName("Position 이동")
	void moveTest() {
		Position position = new Position();
		position.move(() -> true);
		position.move(() -> false);
		assertThat(position).isEqualTo(new Position(1));
	}

}
