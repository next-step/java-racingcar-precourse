package racinggame.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
	List<Car> cars;

	public Cars(String carNames) {
		cars = makeCarList(carNames);
	}

	private List<Car> makeCarList(String carNames) {
		cars = new ArrayList<>();
		for (String name : carNames.split(",")) {
			cars.add(new Car(name));
		}
		return cars;
	}

	/**
	 * 자동차들 진행
	 */
	public void roll() {
		for (Car car : cars) {
			car.roll();
		}
	}

	/**
	 * 자동차들 상태 종합
	 * @return 자동차들 상태 종합 문자열
	 */
	public String getStatus() {
		StringBuffer sbStatus = new StringBuffer();
		for (Car car : cars) {
			sbStatus.append(car.getStatus());
			sbStatus.append("\n");
		}
		return sbStatus.toString();
	}
	

	/**
	 * 우승자 이름들 반환.
	 * @return
	 */
	public String getWinnerNames() {
		StringBuffer sbWinnerNames = new StringBuffer();
		for (Car car : chooseWinners()) {
			sbWinnerNames.append(",");
			sbWinnerNames.append(car.getName());
		}
		return sbWinnerNames.toString().replaceFirst(",", "");
	}

	/**
	 * 우승자들 선정
	 * @return
	 */
	private List<Car> chooseWinners() {
		WinnerTravel winnerTravel = new WinnerTravel(cars);
		List<Car> winners = new ArrayList<>(cars);
		winners.removeIf(car -> winnerTravel.isWinner(car));
		return winners;
	}
}
