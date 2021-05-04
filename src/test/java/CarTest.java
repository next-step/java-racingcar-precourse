import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {

	@Test
	void createCar() {
		Throwable thrown = catchThrowable(() -> new Car("helloworld"));
		assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void testMove() {
		Car car = new Car("tcar");
		car.move(5);
		car.move(6);
		assertThat(car.getPosition()).isEqualTo(2);
	}

	@Test
	void testPositionString() {
		Car car = new Car("tcar");
		car.move(5);
		car.move(6);
		car.move(3);
		assertThat(car.getPositionString()).isEqualTo("--");
	}

}
