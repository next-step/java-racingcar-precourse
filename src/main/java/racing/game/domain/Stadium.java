package racing.game.domain;

import java.util.List;

public class Stadium {
	Cars cars;
	int lapCount;
	List<Car> winnerCars;

	public Stadium(List<String> carNames) {
		cars = new Cars(carNames);
		lapCount = 0;
	}

	public int size() {
		return cars.size();
	}

	public void setLapCount(int lapCount) {
		this.lapCount = lapCount;
	}

	public void startLap() {
		for (int i = 0; i < lapCount; i++) {
			cars.runLab();
			cars.showLabStatus();
		}
		System.out.println();
	}

	public List<Car> chooseWinnerCars() {
		winnerCars = cars.getWinnerCars();
		return winnerCars;
	}

	public String getWinnerCar() {
		StringBuffer winners = new StringBuffer();
		for (Car car : winnerCars) {
			joinDelemiter(winners);
			winners.append(car.carName);
		}
		winners.append(" 이 우승했습니다.");
		return winners.toString();
	}

	private void joinDelemiter(StringBuffer winners) {
		if (!winners.toString().equals("")) {
			winners.append(",");
		}
	}

	public void showWinnerCar() {
		System.out.println(getWinnerCar());
	}
}
