package racinggame;

import static org.assertj.core.api.Assertions.*;
import static racinggame.common.CommonConstants.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racinggame.common.ErrorMessage;
import racinggame.domain.Car;

public class CarTest {

	Car car;

	@BeforeEach
	void setUp() {
		car = new Car("test");
	}

	@Test
	void 생성자_이름입력() {
		String name = "test";
		Car car = new Car(name);
		assertThat(car.getName()).isEqualTo(name);
		assertThat(car.getDistance()).isEqualTo(0);
	}

	@Test
	void 자동차_이름_설정() {
		String name = "test";
		car.setName(name);
		assertThat(car.getName()).isEqualTo(name);
		assertThat(car.getDistance()).isEqualTo(0);
	}

	@Test
	void 자동차_이름_설정_에러() {
		String name = "";
		assertThatThrownBy(() -> car.setName(name))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(ErrorMessage.ERROR_CAR_INPUT_NAME);
	}

	@Test
	void 생성자_이름입력_에러() {
		String name = "테스트  입니다";
		assertThatThrownBy(() -> new Car(name))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(ErrorMessage.ERROR_CAR_INPUT_NAME);
	}

	@Test
	void 전진() {
		car.go();
		assertThat(car.getDistance()).isEqualTo(1);
		car.go();
		assertThat(car.getDistance()).isEqualTo(2);
	}

	@ParameterizedTest(name = "레이스 {index}")
	@ValueSource(ints = {1, 4, 5, 9})
	void 레이스(int randomValue) {
		car.race(randomValue);

		int result = (randomValue >= GO_VALUE) ? 1 : 0;
		assertThat(car.getDistance()).isEqualTo(result);
	}

	@Test
	void 문자열_변환() {
		String name = "test";
		car = new Car(name);
		car.go();
		car.go();
		car.go();
		assertThat(car.toString()).contains(name + " : ---");
	}

}
