package racing.game.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
	static String inputCarName;
	static Car car;

	@BeforeAll
	public static void setUp() {
		inputCarName = "벤츠";
		car = new Car(inputCarName);
	}

	@Test
	@DisplayName("이동 했는지 여부 확인")
	public void getCarInfo() {

		int prePosition = car.getPosition();
		car.movePosition();

		if (car.getCurrentMoveState()) {
			int postPosition = car.getPosition();
			assertThat(postPosition).isEqualTo(prePosition + 1);
		}

		assertThat(inputCarName).isEqualTo(car.getCarName());
	}

	@Test
	@DisplayName("위치에 맞는 그래프를 나타낼 수 있다.")
	public void drawGraph() {
		assertThat(car.getResultGraph(0)).isEqualTo("벤츠:");
		assertThat(car.getResultGraph(1)).isEqualTo("벤츠:-");
		assertThat(car.getResultGraph(3)).isEqualTo("벤츠:---");
	}

}