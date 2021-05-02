import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racingcar.Car;
import racingcar.CarStatus;

public class CarTest {
	private Car benz;

	@BeforeEach
	void init() {
		benz = new Car("benz");
	}

	@Test
	void 자동차_이동() {
		CarStatus carStatus = benz.paly(4);
		assertThat(carStatus).isEqualTo(CarStatus.GO);
	}

	@Test
	void 자동차_정지() {
		CarStatus carStatus = benz.paly(3);
		assertThat(carStatus).isEqualTo(CarStatus.STOP);
	}
}
