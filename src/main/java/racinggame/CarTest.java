package racinggame;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class CarTest {
	
	
	@Test
	void go() {
		Car car=new Car("Ssing");
		car.gogo(5);
		assertThat(car.get_distance()).isEqualTo(1);
		
	}
	
	@Test
	void stop(){
		Car car=new Car("brung");
		car.gogo(2);
		assertThat(car.get_distance()).isEqualTo(0);
	}

}
