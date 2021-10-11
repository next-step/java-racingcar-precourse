package racinggame;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Test;

public class CarTest {

	@Test
	void race(){
		Car car = new Car("chang");
		car.race(5);
		assertThat(car.getPosition()).isEqualTo(1);
		car.race(3);
		assertThat(car.getPosition()).isEqualTo(1);
		car.race(7);
		assertThat(car.getPosition()).isEqualTo(2);
	}

}
