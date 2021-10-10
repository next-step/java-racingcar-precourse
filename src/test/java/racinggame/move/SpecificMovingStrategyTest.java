package racinggame.move;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import racinggame.generator.SpecificNumberGenerator;

class SpecificMovingStrategyTest {

	@DisplayName("4보다 큰 값인 경우 움직인다.")
	@ParameterizedTest
	@CsvSource(value = {"4:MOVE", "3:STOP"}, delimiter = ':')
	void move(int input, MoveStatus moveStatus) {
		// given
		final SpecificMovingStrategy strategy = new SpecificMovingStrategy(new SpecificNumberGenerator(input));

		// when then
		assertEquals(moveStatus, strategy.move());
	}

}