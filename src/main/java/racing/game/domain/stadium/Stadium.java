package racing.game.domain.stadium;

import java.util.List;

import racing.game.domain.car.Car;
import racing.game.domain.car.Cars;
import racing.game.properties.RacingMessage;

public class Stadium {
	private Cars cars;
	private int lapCount;
	private List<Car> winnerCars;

	public Stadium(List<String> carNames, int lapCount) {
		cars = new Cars(carNames);
		this.lapCount = lapCount;
	}

	public int size() {
		return cars.size();
	}

	public void startLap() {
		for (int i = 0; i < lapCount; i++) {
			cars.runLab();
			cars.showLabStatus();
		}
	}

	public List<Car> chooseWinnerCars() {
		winnerCars = cars.getWinnerCars();
		return winnerCars;
	}

	public String getWinnerCar() {
		StringBuffer winners = new StringBuffer();
		for (Car car : winnerCars) {
			joinDelemiter(winners);
			winners.append(car.getCarName());
		}
		winners.append(RacingMessage.INFO_WINNER);
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
