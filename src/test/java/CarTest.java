import static org.assertj.core.api.Assertions.*;

import java.util.List;

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
	void 자동차_1번_이동() {
		Car benz = new Car("benz");
		benz.isForward(4);
		assertThat(benz.getCarPosition().getPosition()).isEqualTo(1);
	}

	@Test
	void 자동차_2번_이동() {
		Car benz = new Car("benz");
		benz.isForward(4);
		benz.isForward(4);
		assertThat(benz.getCarPosition().getPosition()).isEqualTo(2);
	}

	@Test
	void 자동차_2번_이동_1번_정지() {
		Car benz = new Car("benz");
		benz.isForward(4);
		benz.isForward(4);
		benz.isForward(3);
		assertThat(benz.getCarPosition().getPosition()).isEqualTo(2);
	}

	@Test
	void 자동차_2번_이동_1번_정지_History_출력() {
		Car benz = new Car("benz");
		benz.isForward(4);
		benz.isForward(4);
		benz.isForward(3);
		assertThat(benz.getCarPosition().getPosition()).isEqualTo(2);

		List<CarStatus> carStatusList = benz.getCarPosition().getCarStatusList();
		for(CarStatus status : carStatusList) {
			System.out.println(status);
		}
	}
}
