import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

	private static Car classCar = new Car("테스트 자동차");

	@BeforeAll
	static void createCar() {
		do {
			classCar.applyForwardOrNot();
		} while (10 > classCar.getCarMileage());
	}

	@Test
	@DisplayName("자동차 전진 여부 적용")
	void applyForwardOrNot() {
		Car car = new Car("applyForwardOrNot 자동차");
		do {
			car.applyForwardOrNot();
		} while (0 == car.getCarMileage());
		assertThat(car.getCarMileage())
			.isEqualTo(1);
	}

	@Test
	@DisplayName("자동차 현재 주행거리 표시")
	public void printCurrentCarMileage() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(classCar.getCarName()).append(" : ");
		for (int i = 0; i < classCar.getCarMileage(); i++) {
			stringBuilder.append("-");
		}
		System.out.println(stringBuilder.toString());
		assertThat(stringBuilder.toString())
			.isEqualTo("테스트 자동차 : ----------");
	}

}
