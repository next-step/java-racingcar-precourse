package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DistanceTest {
	private Distance distance;
	private int prevDistance;
	private int currentDistance;

	@BeforeEach
	void init() {
		distance = new Distance(0);
		prevDistance = 0;
		currentDistance = 0;
	}

	@Test
	@DisplayName("4이상이면 전진 3이하면 멈춤")
	void move() {
		// given
		prevDistance = distance.getDistance();

		// when
		distance.move(5);
		currentDistance = distance.getDistance();
		// then
		assertThat(currentDistance).isNotEqualTo(prevDistance);

		// given
		prevDistance = distance.getDistance();

		// when
		distance.move(2);
		currentDistance = distance.getDistance();
		// then
		assertThat(currentDistance).isEqualTo(prevDistance);

		// given
		prevDistance = distance.getDistance();

		// when
		distance.move(8);
		currentDistance = distance.getDistance();
		// then
		assertThat(currentDistance).isNotEqualTo(prevDistance);
	}
}
