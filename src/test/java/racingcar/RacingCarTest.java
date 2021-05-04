package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sun.security.validator.ValidatorException;

public class RacingCarTest {

	private RacingCar racingCar;

	@BeforeEach
	void setUp() throws ValidatorException {
		racingCar = new RacingCar(Arrays.asList("pobi", "crong", "honux"));
	}

	@Test
	void playTest() {
		racingCar.play();
		racingCar.play();
		racingCar.play();
		racingCar.play();
	}

	@Test
	void printResultTest() {
		playTest();
		System.out.println(racingCar.getWinners());
	}

	@Test
	void getWinnersTest() {
		assertThat(racingCar.getWinners()).isEqualTo("pobi, crong, honux");
	}
}
