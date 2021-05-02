public class Car {

	private final String carName;

	public Car(String carName) {
		this.carName = carName;
	}

	public String getCarName() {
		return carName;
	}

	// 자동차 이름 검증
	public boolean isValidCarName(String carName) {
		return 5 >= carName.length() && 1 <= carName.length();
	}

	// 자동차 대수 검증
	public boolean isValidCarCount(String[] carNameArr) {
		return 2 <= carNameArr.length;
	}

	// 자동차 이름 목록 검증
	public boolean isValidCarNames(String[] carNameArr) {
		int loopCount = 0;
		boolean validCarNameResult = true;
		while (loopCount < carNameArr.length && validCarNameResult) {
			validCarNameResult = isValidCarName(carNameArr[loopCount]);
			loopCount++;
		}
		return loopCount == carNameArr.length && validCarNameResult;
	}

	// 사용자 입력 자동차 이름들 검증
	public boolean isValidCar(String[] carNameArr) {
		if (!isValidCarCount(carNameArr)) {
			return false;
		}
		return isValidCarNames(carNameArr);
	}

}
