package racinggame.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DistanceTest {

	@Test
	@DisplayName("이동거리를 생성한다.")
	public void createDistance() {
		Distance distance = new Distance(2);

		assertThat(distance).isEqualTo(new Distance(2));
	}

	@Test
	@DisplayName("이동거리는 음수가 되면 예외가 발생한다.")
	public void checkPositive() {
		assertThrows(IllegalArgumentException.class,
			() -> new Distance(-1));
	}

	@Test
	@DisplayName("이동 조건 숫자가 4이상이면 1씩 증가한다.")
	public void moveDistance() {
		Distance distance = new Distance(0);

		assertAll(
			() -> assertThat(distance.move(4)).isEqualTo(new Distance(1)),
			() -> {
				Distance result1 = distance.move(4);
				Distance result2 = result1.move(3);
				assertThat(result2).isEqualTo(new Distance(1));
			}
		);
	}
}