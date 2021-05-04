import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class Cars {

	private final List<Car> carList;
	private final int raceCount;

	private static final String MESSAGE_PLEASE_INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String CAR_NAMES_SPLITTER = ",";
	private static final String WINNER_SPLITTER = ", ";

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
	private boolean isValidCarNames(String[] carNameArr) {
		int loopCount = 0;
		boolean validCarNameResult = true;
		while (loopCount < carNameArr.length && validCarNameResult) {
			validCarNameResult = Car.isValidCarName(carNameArr[loopCount]);
			loopCount++;
		}
		return loopCount == carNameArr.length && validCarNameResult;
	}

	// 사용자 입력 자동차 이름들 검증
	private boolean isValidCar(String[] carNameArr) {
		if (!Car.isValidCarCount(carNameArr)) {
			return false;
		}
		return isValidCarNames(carNameArr);
	}

	// 자동차 이름 얻기
	public String[] getCarNames() {
		String[] carNameArr;
		do {
			System.out.println(MESSAGE_PLEASE_INPUT_CAR_NAMES);
			carNameArr = new Scanner(System.in).nextLine().split(CAR_NAMES_SPLITTER);
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
		StringJoiner stringJoiner = new StringJoiner(WINNER_SPLITTER);
		for (Car car : getCarList()) {
			getWinnerName(car, stringJoiner);
		}
		return stringJoiner.toString();
	}

	// 우승 자동차 이름 얻기
	private void getWinnerName(Car car, StringJoiner stringJoiner) {
		if (car.isWinner(getRaceCount())) {
			stringJoiner.add(car.getCarName());
		}
	}

}
