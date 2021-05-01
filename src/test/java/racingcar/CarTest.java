package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
	Car car;
	
	@BeforeEach
	void init() {
		car = new Car("pobi");
		car.go();
	}

	@Test
	@DisplayName("차가 전진한다.")
	void go() {
		assertThat(car.getMovesSize()).isEqualTo(1);
	}

	@Test
	@DisplayName("우승여부를 판단한다.")
	void isWinner() {
		assertThat(car.isWinner(1)).isTrue();
	}
}