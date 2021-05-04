import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class Cars {

	private final List<Car> carList;
	private final int raceCount;

	public Cars(List<Car> carList, int raceCount) {
		this.carList = carList;
		this.raceCount = raceCount;
	}

	public List<Car> getCarList() {
		return carList;
	}

	public int getRaceCount() {
		return raceCount;
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

	// 레이스 1회 수행 및 주행거리 표시
	public void goRace() {
		for (Car car : getCarList()) {
			car.applyForwardOrNot();
			car.printCurrentCarMileage();
		}
		System.out.println(""); // 레이스 1회 구분라인
	}

	// 게임 결과 생성
	public String creatRaceResult() {
		StringJoiner stringJoiner = new StringJoiner(", ");
		for (Car car : getCarList()) {
			stringJoiner = getWinnerName(car, stringJoiner);
		}
		return stringJoiner.toString();
	}

	// 우승 자동차 이름 얻기
	public StringJoiner getWinnerName(Car car, StringJoiner stringJoiner) {
		if (car.isWinner(getRaceCount())) {
			stringJoiner.add(car.getCarName());
		}
		return stringJoiner;
	}

}
