package racinggame.racingcar;

import static org.assertj.core.api.Assertions.*;
import static racinggame.racingcar.Racing.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LocationTest {
	private Location location;

	@DisplayName("앞으로 이동한다.")
	@Test
	void forward() {
		//given
		int initLocation = 0;
		location = new Location(initLocation);

		//when
		location.forward();

		//then
		assertThat(location.valueOf()).isEqualTo(initLocation + FORWARD.movable());
	}
}