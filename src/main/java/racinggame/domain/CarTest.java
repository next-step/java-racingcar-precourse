package racinggame.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class CarTest {
	
	@Test
	void go() {
		Car car=new Car("æ≈æ≈¿Ã");
		car.gogo(5);
		assertThat(car.Car_distance()).isEqualTo(1);
		
	}
	
	@Test
	void stop(){
		Car car=new Car("∫ÿ∫ÿ¿Ã");
		car.gogo(2);
		assertThat(car.Car_distance()).isEqualTo(0);
	}

}
