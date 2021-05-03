import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import racingcar.Car;
import racingcar.CarStatus;

public class CarTest {
	@Test
	void 자동차_이름_검증_빈값() {
		String carName = "";
		assertThatIllegalArgumentException().isThrownBy(() -> {
			new Car(carName);
		}).withMessageContaining("입력된 이름이 없습니다.");
	}

	@Test
	void 자동차_이름_검증_5자초과() {
		String carName = "abcdefg";
		assertThatIllegalArgumentException().isThrownBy(() -> {
			new Car(carName);
		}).withMessageContaining("이름은 5자 이하만 가능합니다.");
	}

	@Test
	void 자동차_이동() {
		Car benz = new Car("benz");
		CarStatus carStatus = benz.isForward(4);
		assertThat(carStatus).isEqualTo(CarStatus.GO);
	}

	@Test
	void 자동차_정지() {
		Car benz = new Car("benz");
		CarStatus carStatus = benz.isForward(3);
		assertThat(carStatus).isEqualTo(CarStatus.STOP);
	}

	@Test
	void 자동차_3번이동() {
		Car benz = new Car("benz");
		benz.forwardPosition();
		benz.forwardPosition();
		benz.forwardPosition();

		benz.printName();
		benz.printCurrentPosition();
	}
}
