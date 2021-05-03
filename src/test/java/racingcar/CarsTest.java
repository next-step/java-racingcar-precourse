package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class CarsTest {

	@Test
	public void 크기가_0인_배열_입력시_객체_생성_실패() {
		String[] carNames = new String[0];
		assertThatThrownBy(() -> new Cars(carNames)).isExactlyInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void NULL_입력시_객체_생성_실패() {
		String[] carNames = null;
		assertThatThrownBy(() -> new Cars(carNames)).isExactlyInstanceOf(IllegalArgumentException.class);
	}

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
		assertThat(winners).contains(red, green);
	}

}
