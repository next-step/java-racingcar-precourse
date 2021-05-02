public class Car {

	private final String carName;

	public Car(String carName) {
		this.carName = carName;
	}

	public String getCarName() {
		return carName;
	}

	// 자동차 이름 검증
	boolean isValidCarName(String carName) {
		return 5 >= carName.length() && 1 <= carName.length();
	}

	// 자동차 대수 검증
	boolean isValidCarCount(String[] carNameArr) {
		return 2 <= carNameArr.length;
	}

}
