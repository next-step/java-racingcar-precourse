package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import sun.security.validator.ValidatorException;

public class RacingCarTest {

	private RacingCar racingCar;

	@BeforeEach
	void setUp() throws ValidatorException {
		racingCar = new RacingCar(Arrays.asList("pobi", "crong", "honux"));
	}

	@Test
	@DisplayName("레이싱 게임 이동 결과 확인")
	void playTest() {
		racingCar.playAndPrintResult();
		racingCar.playAndPrintResult();
		racingCar.playAndPrintResult();
		racingCar.playAndPrintResult();
	}

	@Test
	@DisplayName("레이싱 게임 우승자 목록 출력")
	void printResultTest() {
		playTest();
		System.out.println(racingCar.getWinners());
	}

	@Test
	@DisplayName("레이싱 게임 우승자 목록 테스트")
	void getWinnersTest() {
		assertThat(racingCar.getWinners()).isEqualTo("pobi, crong, honux");
	}
}
