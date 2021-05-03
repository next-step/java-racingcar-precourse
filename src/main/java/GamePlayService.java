import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GamePlayService {

	// 게임 시작
	public void startGame() {
		String[] carNameArr = new Cars(null, 0).getCarNames();
		List<Car> carList = creatCars(carNameArr);
		int playCount = getPlayCount();
		Cars cars = new Cars(carList, playCount);
		playRace(cars);

		String gameResult = "";
		do {
			gameResult = cars.creatRaceResult();
		} while (0 == gameResult.length());
		System.out.println(gameResult + "가 우승하였습니다");
	}

	// 자동차 목록 생성
	private List<Car> creatCars(String[] carNameArr) {
		List<Car> carList = new ArrayList<>();
		for (String carName : carNameArr) {
			carList.add(new Car(carName));
		}
		return carList;
	}

	// 레이스 시작
	private void playRace(Cars cars) {
		for (int i = 0; i < cars.getPlayCount(); i++) {
			cars.goRace();
		}
	}

	// 1 이상인지 검증
	boolean isAboveMinimum(int playCount) {
		if (1 > playCount) {
			System.out.println("1이상의 숫자를 입력해 주세요.");
			return false;
		}
		return true;
	}

	// 숫자인지 검증
	boolean isNumber(String playCount) {
		try {
			return isAboveMinimum(Integer.parseInt(playCount));
		} catch (NumberFormatException e) {
			System.out.println("숫자를 입력해 주세요.");
			return false;
		}
	}

	// 레이싱 횟수 얻기
	int getPlayCount() {
		String playCount;
		do {
			System.out.println("시도할 회수는 몇 회인가요?");
			playCount = new Scanner(System.in).nextLine();
		} while (!isNumber(playCount));
		return Integer.parseInt(playCount);
	}

}
