import java.util.Scanner;

public class Car {

	private final String carName;
	private int carMileage;

	public Car(String carName) {
		this.carName = carName;
		this.carMileage = 0;
	}

	public String getCarName() {
		return carName;
	}

	// 자동차 전진 여부 적용
	public void applyForwardOrNot(boolean forwardOrNot) {
		if (forwardOrNot) {
			this.carMileage++;
		}
	}

	// 자동차 이름 검증
	public static boolean isValidCarName(String carName) {
		return 5 >= carName.length() && 1 <= carName.length();
	}

	// 자동차 대수 검증
	public static boolean isValidCarCount(String[] carNameArr) {
		return 2 <= carNameArr.length;
	}

}
