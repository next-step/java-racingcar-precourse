package racinggame;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class CarsTest {

	@Test
	void 자동차들의_이름을_부여한_목록을_보유한다() {
		Cars cars = new Cars(Arrays.asList("carA", "carB", "carC"));

		assertThat(cars.size()).isEqualTo(3);
	}

	@Test
	void 자동자들의_이름은_중복되면_안된다() {
		assertThatThrownBy(() -> new Cars(Arrays.asList("carA", "carB", "carB")))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("중복된 이름은 사용할 수 없습니다");
	}
}
