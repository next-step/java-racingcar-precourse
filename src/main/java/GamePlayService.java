import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GamePlayService {

	// 게임 시작
	public void startGame() {
		Cars cars = creatCars();
		playRace(cars);
		printGameResult(cars);
	}

	// 자동차 목록 생성
	private Cars creatCars() {
		List<Car> carList = new ArrayList<>();
		String[] carNameArr = new Cars(null, 0).getCarNames();
		int raceCount = getRaceCount();

		for (String carName : carNameArr) {
			carList.add(new Car(carName));
		}
		return new Cars(carList, raceCount);
	}

	// 레이스 시작
	private void playRace(Cars cars) {
		for (int i = 0; i < cars.getRaceCount(); i++) {
			cars.goRace();
		}
	}

	// 게임 결과 출력
	private void printGameResult(Cars cars) {
		String gameResult = "";
		do {
			gameResult = cars.creatRaceResult();
		} while (0 == gameResult.length());
		System.out.println(gameResult + "가 우승하였습니다");
	}


	// 1 이상인지 검증
	boolean isAboveMinimum(int raceCount) {
		if (1 > raceCount) {
			System.out.println("1이상의 숫자를 입력해 주세요.");
			return false;
		}
		return true;
	}

	// 숫자인지 검증
	boolean isNumber(String raceCount) {
		try {
			return isAboveMinimum(Integer.parseInt(raceCount));
		} catch (NumberFormatException e) {
			System.out.println("숫자를 입력해 주세요.");
			return false;
		}
	}

	// 레이싱 횟수 얻기
	int getRaceCount() {
		String raceCount;
		do {
			System.out.println("시도할 회수는 몇 회인가요?");
			raceCount = new Scanner(System.in).nextLine();
		} while (!isNumber(raceCount));
		return Integer.parseInt(raceCount);
	}

}
