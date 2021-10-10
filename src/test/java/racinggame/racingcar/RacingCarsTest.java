package racinggame.racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racinggame.constants.CommonConstants;
import racinggame.generator.SpecificNumberGenerator;
import racinggame.move.SpecificMovingStrategy;

public class RacingCarsTest {

	private RacingCar pobi;
	private RacingCar honux;
	private RacingCar crong;

	private int pobiPosition = 1;
	private int honuxPosition = 2;
	private int crongPosition = 3;

	private int pobiGenerate = 3;
	private int honuxGenerate = 4;
	private int crongGenerate = 5;

	@BeforeEach
	void setUp() {
		pobi = new RacingCar("pobi", pobiPosition,
			new SpecificMovingStrategy(new SpecificNumberGenerator(pobiGenerate)));
		honux = new RacingCar("honux", honuxPosition,
			new SpecificMovingStrategy(new SpecificNumberGenerator(honuxGenerate)));
		crong = new RacingCar("crong", crongPosition,
			new SpecificMovingStrategy(new SpecificNumberGenerator(crongGenerate)));
	}

	@DisplayName("자동차들의 위치 중 가장 큰 위치를 반환한다.")
	@Test
	void getGreatestPosition() {
		// given
		final RacingCars racingCars = new RacingCars(Arrays.asList(pobi, honux, crong));

		// when then
		assertEquals(new Position(crongPosition), racingCars.getGreatestPosition());
	}

	@DisplayName("자동차들을 움직인다.")
	@Test
	void move() {
		// given
		final RacingCars racingCars = new RacingCars(Arrays.asList(pobi, honux, crong));

		// when then
		assertEquals(racingCars.move(), new RacingCars(Arrays.asList(
			new RacingCar("pobi", pobiPosition,
				new SpecificMovingStrategy(new SpecificNumberGenerator(pobiGenerate))),
			new RacingCar("honux", honuxPosition + 1,
				new SpecificMovingStrategy(new SpecificNumberGenerator(honuxGenerate))),
			new RacingCar("crong", crongPosition + 1,
				new SpecificMovingStrategy(new SpecificNumberGenerator(crongGenerate))))));
	}

	@DisplayName("자동차들의 위치 및 이름을 반환한다.")
	@Test
	void toString_test() {
		// given
		final RacingCars racingCars = new RacingCars(Arrays.asList(pobi, honux, crong));

		// when then
		assertEquals(racingCars.toString(),
			"pobi : -" + CommonConstants.NEWLINE
				+ "honux : --" + CommonConstants.NEWLINE
				+ "crong : ---" + CommonConstants.NEWLINE);
	}

}
