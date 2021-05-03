import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class Cars {

	private final List<Car> carList;

	public Cars(List<Car> carList) {
		this.carList = carList;
	}

	public List<Car> getCarList() {
		return carList;
	}

	// 자동차 이름 목록 검증
	public boolean isValidCarNames(String[] carNameArr) {
		int loopCount = 0;
		boolean validCarNameResult = true;
		while (loopCount < carNameArr.length && validCarNameResult) {
			validCarNameResult = Car.isValidCarName(carNameArr[loopCount]);
			loopCount++;
		}
		return loopCount == carNameArr.length && validCarNameResult;
	}

	// 사용자 입력 자동차 이름들 검증
	public boolean isValidCar(String[] carNameArr) {
		if (!Car.isValidCarCount(carNameArr)) {
			return false;
		}
		return isValidCarNames(carNameArr);
	}

	// 자동차 이름 얻기
	public String[] getCarNames() {
		String[] carNameArr;
		do {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
			carNameArr = new Scanner(System.in).nextLine().split(",");
		} while (!isValidCar(carNameArr));

		return carNameArr;
	}

	// 모든 자동차 주행거리 표시
	public void printCarsMileage() {
		for (Car car : carList) {
			car.printCurrentCarMileage();
		}
	}

	// 레이싱 1회 수행
	public void goRace() {
		for (Car car : carList) {
			car.applyForwardOrNot(car.getForwardOrNot());
		}
		printCarsMileage();
	}

	// 우승 자동차 이름 얻기
	public StringJoiner getWinnerName(Car car, int playCount, StringJoiner stringJoiner) {
		if (car.isWinner(playCount)) {
			stringJoiner.add(car.getCarName());
		}
		return stringJoiner;
	}

}
