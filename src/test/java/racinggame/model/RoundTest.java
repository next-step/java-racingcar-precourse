package racinggame.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RoundTest {

	@DisplayName("하나의 게임을 생성")
	@Test
	void create() {
		Round round = new Round(Arrays.asList(Car.valueOf("car-1"), Car.valueOf("car-2")));

		assertThat(round).isNotNull();
	}

	@DisplayName("게임 진행")
	@Test
	void play_round() {
		Round round = new Round(Arrays.asList(Car.valueOf("car-1"), Car.valueOf("car-2")));
		RoundResult result = round.play();

		assertThat(result).isNotNull();
		assertThat(result.numberOfCar()).isEqualTo(2);
	}
}