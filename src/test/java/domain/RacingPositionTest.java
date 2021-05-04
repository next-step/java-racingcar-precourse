
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import domain.RacingPosition;

public class RacingPositionTest {

	@ParameterizedTest
	@CsvSource(value = {"4,1", "9,1", "1,0"})
	@DisplayName("숫자가 4 이상인 경우 전진, 4 미만인 경우 정지한다.")
	void moveTest(int randomNumber, int expectedResult) {
		int moveStandard = 4;
		int position = 0;
		RacingPosition currentPosition = new RacingPosition();

		currentPosition.move(randomNumber);

		assertThat(currentPosition.getPosition()).isEqualTo(position + expectedResult);
	}
}
