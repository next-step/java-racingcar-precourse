
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarTest {
	public static final int DEFAULT_POSITION = 0;

	@Test
	void 자동차_이름을_부여한다() {
		String carName = "test";
		Car car = new Car(carName, DEFAULT_POSITION);
		assertThat(car.name).isNotEmpty();
	}

	@Test
	void 자동차_한칸씩_이동() {
		String carName = "test";
		Car car = new Car(carName, DEFAULT_POSITION);
		car.move();
		if (car.score >= car.POSSIBLE_MOVE_SCORE) {
			assertThat(car.position).isEqualTo(1);
		} else {
			assertThat(car.position).isEqualTo(0);
		}
	}

	@Test
	void 자동차_랜덤에_숫자뽑기() {
		String carName = "test";
		Car car = new Car(carName, DEFAULT_POSITION);
		int random = car.getRandomNumber();
		System.out.println("random : " + random);
		assertThat(random).isNotZero();
	}
}
