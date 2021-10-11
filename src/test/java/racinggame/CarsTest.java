package racinggame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarsTest {

	@Test
	void 자동차들의_이름을_부여한_목록을_보유한다() {
		Cars cars = new Cars("carA", "carB", "carC");

		assertThat(cars.size()).isEqualTo(3);
	}

	@Test
	void 자동자들의_이름은_중복되면_안된다() {
		assertThatThrownBy(() -> new Cars("carA", "carB", "carB"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("중복된 이름은 사용할 수 없습니다");
	}

	@Test
	void 우승자동차를_부른다() {
		Cars cars = new Cars("carA", "carB", "carC");
		cars.race();
		cars.race();

		CarNames winnerCars = cars.getWinnerNames();

		System.out.println(winnerCars);
	}
}
