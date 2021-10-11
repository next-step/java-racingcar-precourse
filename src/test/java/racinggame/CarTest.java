package racinggame;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Test;

public class CarTest {

	@Test
	void 랜덤수에_대한_자동차_전진(){
		Car car = new Car("chang");
		car.race(5);
		assertThat(car.getPosition()).isEqualTo(1);
		car.race(3);
		assertThat(car.getPosition()).isEqualTo(1);
		car.race(7);
		assertThat(car.getPosition()).isEqualTo(2);
	}

	@Test
	void 자동차_현재_위치_출력(){
		Car car = new Car("chang");
		car.race(5);
		car.race(3);
		car.race(7);

		assertThat(car.getStringCarResult()).isEqualTo("chang : --");

	}

}
