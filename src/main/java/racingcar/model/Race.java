package racingcar.model;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Race {

	private static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	public static final String FINAL_WINNER = "최종 우승자: ";
	private List<Car> carList = new ArrayList<>();

	public Race() {

	}

	public void inputCarNames() {
		System.out.println(INPUT_CAR_NAME);
		String carNames = Console.readLine();
		String[] carArray = carNames.split(",");
		for (String car : carArray) {
			carList.add(new Car(car));
		}
	}

	public Race(List<Car> carList) {
		this.carList = carList;
	}

	public void racing() {
		for (Car car : carList) {
			car.advance(Randoms.pickNumberInRange(0, 9));
		}
		printStatus();
	}

	private void printStatus() {
		for (Car car : carList) {
			System.out.println(car.getCarName() + " : " + repeatString(car.getDistance()));
		}
		System.out.println();
	}

	private static String repeatString(int distance) {
		return new String(new char[distance]).replace("\0", "-");
	}

	public void getWinner() {
		Map<String, Integer> carMap = new HashMap<>();
		for (Car car : carList) {
			carMap.put(car.getCarName(), car.getDistance());
		}
		int maxValue = Collections.max(carMap.values());
		ArrayList<String> winnerList = new ArrayList<>();
		for (Map.Entry<String, Integer> m : carMap.entrySet()) {
			if (m.getValue() == maxValue) {
				winnerList.add(m.getKey());
			}
		}
		winnerPrint(winnerList);
	}

	private void winnerPrint(ArrayList<String> winnerList) {
		System.out.println(FINAL_WINNER + String.join(", ", winnerList));
	}
}
