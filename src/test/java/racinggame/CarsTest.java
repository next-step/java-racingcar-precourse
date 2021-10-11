package racinggame;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class CarsTest {
	@Test
	void 자동차_이름_분할(){
		Cars cars = new Cars(Arrays.asList("chang,hyuk,park".split(",")), "3");
		assertThat(cars.getNumberOfCars()).isEqualTo(3);
	}
}
