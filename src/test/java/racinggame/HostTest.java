package racinggame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racinggame.controller.Host;
import racinggame.domain.Racing;

public class HostTest {
	Host host;

	@BeforeEach
	void setUp() {
		host = new Host();
	}

	@Test
	void 레이싱_참가() {
		String input = "pobi,crong,honux";

		host.setRacingCars(input);
		Racing racing = host.getRacing();

		assertThat(racing.getCarList())
			.hasSize(3)
			.asString()
			.contains("pobi")
			.contains("crong")
			.contains("honux");
	}

}
