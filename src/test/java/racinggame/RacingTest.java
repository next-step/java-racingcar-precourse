package racinggame;

import static org.assertj.core.api.Assertions.*;
import static racinggame.common.ErrorMessage.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racinggame.domain.Car;
import racinggame.domain.Racing;

public class RacingTest {

	Racing racing;

	@BeforeEach
	void setUp() {
		racing = new Racing();
	}

	@Test
	void 레이싱_참가() {
		List<String> names = Arrays.asList("Lee", "Park", "Kim", "제이", "논");
		for (String name : names) {
			racing.add(new Car(name));
		}
		assertThat(racing.getCarList())
			.hasSize(names.size());
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
	void 전진여부_판단(int value) {
		boolean result = value > racing.GO_VALUE;
		assertThat(racing.isGo(value)).isEqualTo(result);
	}

	@Test
	void 전진여부_예외() {
		int minus = -1;
		assertThatThrownBy(() -> racing.isGo(minus))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(ERROR_GO_INPUT);
		int over = 11;
		assertThatThrownBy(() -> racing.isGo(over))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(ERROR_GO_INPUT);
	}

	@Test
	void 자동차_레이스() {
		List<Integer> list = Arrays.asList(1, 4, 5, 9, 3, 7);
		int goCnt = 0;
		String distance = "";
		for (int i : list) {
			goCnt += (racing.isGo(i)) ? 1 : 0;
			distance += (racing.isGo(i)) ? "-" : "";
		}
		Car car = new Car("lee");
		for (int i : list) {
			racing.race(car, i);
		}

		assertThat(car)
			.extracting("distance")
			.isEqualTo(goCnt);
		assertThat(car)
			.asString()
			.containsSequence(distance);
	}
}
