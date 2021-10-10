package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionTest {

	@DisplayName("자동차 위치 생성")
	@Test
	void create() {
		Position position = Position.init();
		assertThat(position.getValue()).isEqualTo(0);
	}

}
