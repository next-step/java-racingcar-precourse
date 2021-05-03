package car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

	private Car car;

	@BeforeEach
	void setUp() {
		car = new Car("pobi");
	}

	@Test
	@DisplayName("자동차 이름 유효성 어긋나는지 검사")
	void validationCarNameLength() {
		assertThatThrownBy(() -> {
			Car newCar = new Car("pobi555");
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("자동차 이름은 " + Car.NAME_LENGTH_MAX + "자 이하만 가능하다.");
	}

	@Test
	@DisplayName("자동차객체에 이름이 올바르게 저장 되었는지 검사")
	void validataionCarName() {
		Car newCar = new Car("pobi");
		assertThat(newCar.getName()).isEqualTo("pobi");
	}

	@Test
	@DisplayName("자동차가 이동했는지 확인")
	public void move() {
		CarStatus status = car.move(4);
		assertThat(status).isEqualTo(CarStatus.FORWARD);
	}

	@Test
	@DisplayName("자동차가 멈추었는지 확인")
	public void stop() {
		CarStatus status = car.move(3);
		assertThat(status).isEqualTo(CarStatus.STOP);
	}

	@Test
	@DisplayName("자동차가 이동하는 조건을 만족 했을 경우 실제로 이동하였는지 검사")
	public void checkMovePoint() {
		car.updateMoveIndex(car.move(4));
		car.updateMoveIndex(car.move(5));
		car.updateMoveIndex(car.move(6));
		car.updateMoveIndex(car.move(8));
		assertThat(car.getCarIndex().getIndex()).isEqualTo(4);
	}

	@Test
	@DisplayName("자동차의 위치가 변경되지 않았는지 검사")
	public void doNotGainMovePoint() {
		car.updateMoveIndex(car.move(2));
		car.updateMoveIndex(car.move(1));
		car.updateMoveIndex(car.move(2));
		car.updateMoveIndex(car.move(3));
		assertThat(car.getCarIndex().getIndex()).isEqualTo(0);
	}
}
