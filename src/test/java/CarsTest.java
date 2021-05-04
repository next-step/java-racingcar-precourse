import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

	private static Cars classCars;

	@BeforeAll
	static void createCars() {
		List<Car> carList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			carList.add(new Car("자동차" + i));
		}
		classCars = new Cars(carList, 10);
	}

	@Test
	@DisplayName("자동차 이름 목록 검증")
	void isValidCarNames() {
		String[] carNamesArr1 = {"1", "2", "3", "4", "5"};
		String[] carNamesArr2 = {"", "123456"};
		assertThat(classCars.isValidCarNames(carNamesArr1)).isTrue();
		assertThat(classCars.isValidCarNames(carNamesArr2)).isFalse();
	}

	@Test
	@DisplayName("사용자 입력 자동차 이름들 검증")
	void isValidCar() {
		String[] carNamesArr1 = {"1", "2", "3", "4", "5"};
		String[] carNamesArr2 = {"1", "123456"};
		String[] carNamesArr3 = {"1"};
		assertThat(classCars.isValidCar(carNamesArr1)).withFailMessage("carNamesArr1").isTrue();
		assertThat(classCars.isValidCar(carNamesArr2)).withFailMessage("carNamesArr2").isFalse();
		assertThat(classCars.isValidCar(carNamesArr3)).withFailMessage("carNamesArr3").isFalse();
	}

	@Test
	@DisplayName("레이스 1회 수행 및 주행거리 표시")
	public void goRace() {
		classCars.goRace();
		List<Car> carList = classCars.getCarList();
		for (Car car : carList) {
			assertThat(car.getCarMileage())
				.isBetween(0, 1);
		}
	}

}
