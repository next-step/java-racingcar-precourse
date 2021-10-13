package racinggame;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racinggame.model.Car;

public class CarTest {

	private Car car;

	@BeforeEach
	void setUp() {
		car = new Car("chang");
	}

	@Test
	void 자동차_전진(){
		car.move(5);
		assertThat(car.getPosition()).isEqualTo(1);
		car.move(3);
		assertThat(car.getPosition()).isEqualTo(1);
		car.move(7);
		assertThat(car.getPosition()).isEqualTo(2);
	}

	@Test
	void 자동차_명(){
		assertThat(car.getName()).isEqualTo("chang");
		car = new Car("hyuk");
		assertThat(car.getName()).isEqualTo("hyuk");
	}
}
