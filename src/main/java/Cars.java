import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class Cars {

	private final List<Car> carList;
	private final int raceCount;

	private static final String MESSAGE_PLEASE_INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String MESSAGE_VICTORY_CARS = "가 우승하였습니다.";
	private static final String CAR_NAMES_SPLITTER = ",";
	private static final String WINNER_SPLITTER = ", ";

	private static final int VALID_CAR_NAME_RESULT = 0;
	private static final int STRING_LENGTH_ZERO = 0;
	private static final int MINIMUM_RACE_COUNT = 1;

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
		int validCarNameResult = VALID_CAR_NAME_RESULT;
		for (String carName : carNameArr) {
			validCarNameResult += Car.isValidCarName(carName);
		}
		return VALID_CAR_NAME_RESULT == validCarNameResult;
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

	// 레이스 시작
	public void playRace(Cars cars) {
		for (int i = 0; i < cars.getRaceCount(); i++) {
			cars.goRace();
		}
	}

	// 우승 자동차 이름 얻기
	public void getWinnerName(Car car, StringJoiner stringJoiner, int currentRaceCount) {
		if (car.isWinner(currentRaceCount)) {
			stringJoiner.add(car.getCarName());
		}
	}

	// 게임 결과 생성
	public String creatRaceResult(int currentRaceCount) {
		StringJoiner stringJoiner = new StringJoiner(WINNER_SPLITTER);
		for (Car car : getCarList()) {
			getWinnerName(car, stringJoiner, currentRaceCount);
		}
		return stringJoiner.toString();
	}

	// 게임 결과 출력
	public void printGameResult() {
		String gameResult = "";
		int raceCount = getRaceCount();
		do {
			gameResult = creatRaceResult(raceCount);
			raceCount--;
		} while (STRING_LENGTH_ZERO == gameResult.length() && MINIMUM_RACE_COUNT <= raceCount);
		System.out.println(gameResult + MESSAGE_VICTORY_CARS);
	}

}
