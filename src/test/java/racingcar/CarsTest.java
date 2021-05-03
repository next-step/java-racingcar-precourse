package racingcar;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarsTest {

	@Test
	public void 자동차_경주_우승자_찾기() {

		//given
		Car blue = new Car("blue");
		Car red = new Car("red");
		Car green = new Car("green");

		blue.move(0);
		red.move(9);
		red.move(9);
		green.move(9);
		green.move(9);

		Cars cars = new Cars(Arrays.asList(blue, red, green));

		//when
		List<Car> winners = cars.findWinners();

		//then
		Assertions.assertThat(winners).contains(red, green);
	}
}
