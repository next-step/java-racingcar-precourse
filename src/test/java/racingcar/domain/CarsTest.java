package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {
	private static final MoveStrategy FORWARD = () -> true;
	private static final MoveStrategy STOP = () -> false;

	@DisplayName("자동차의 일급컬렉션을 생성한다")
	@Test
	void createTest() {
		String[] names = {"gunan", "k", "lee"};
		assertThat(Cars.of(names)).isNotNull();
	}

	@DisplayName("모든 자동차는 서로 중복될 수 없다")
	@Test
	void notUniqueTest() {
		String[] names = {"gunan", "k", "gunan"};
		assertThatThrownBy(() -> Cars.of(names))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("모든 자동차들 가운데 우승자를 가려낼 수 있다")
	@Test
	void moveAllTest() {
		String[] names = {"gunan", "k", "lee"};
		Cars cars = Cars.of(names);
		cars.moveAll(FORWARD);
		cars.moveAll(STOP);
		Winners winners = cars.winners();
		assertThat(winners.toString()).contains("gunan", "k", "lee");
	}
}
