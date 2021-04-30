
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
	@Test
	@DisplayName("자동차테스트")
	void 자동차테스트() {
		Car car = new Car("테스트");
		int defaultScore = car.getCarScore();
		car.addScore();
		assertEquals(defaultScore, car.getCarScore());
	}
}
