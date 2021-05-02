import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

	// 자동차 이름 검증
	static boolean isValidCarName(String carName) {
		return 5 >= carName.length() && 1 <= carName.length();
	}

	// 자동차 대수 검증
	static boolean isValidCarCount(String[] carNameArr) {
		return 2 <= carNameArr.length;
	}

	@Test
	@DisplayName("자동차 현재 주행거리 표시")
	void printCurrentCarMileage() {
		Car car = new Car("테스트 자동차");
		car.applyForwardOrNot(true);
		car.applyForwardOrNot(true);
		car.printCurrentCarMileage();
	}
	
}
