import java.util.ArrayList;
import java.util.List;

import util.IoUtils;
import util.IoUtilsImpl;

public class Racecourse {

	private IoUtils ioUtils = new IoUtilsImpl();
	private GameRule gameRule = new GameRule();

	public void raceParticipation() {
		ioUtils.output("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String carsStr = ioUtils.input();
		List<Car> cars = setParticipation(carsStr);

		ioUtils.output("시도할 횟수는 몇회인가요?");
		int numberOfAttempts = Integer.parseInt(ioUtils.input());

		raceStart(numberOfAttempts, cars);
		markWinner(cars);
	}

	private List<Car> setParticipation(String carsStr) {
		String[] carsStrArr = carsStr.split(",");
		List<Car> cars = new ArrayList<>();
		for (String s : carsStrArr) {
			cars.add(new Car(s));
		}
		return cars;
	}

	private void raceStart(int numberOfAttempts, List<Car> cars) {
		for (int i = 0; i <= numberOfAttempts; i++) {
			raceOneTime(cars);
			ioUtils.output("");
		}
	}

	private void markWinner(List<Car> cars) {
		List<Car> winners = gameRule.getWinners(cars, gameRule.getWinnerLocation(cars));
		List<String> winnerNames = new ArrayList<>();
		for (Car winner : winners) {
			winnerNames.add(winner.getName());
		}
		String winnersStr = String.join(", ", winnerNames);
		ioUtils.output(winnersStr + "가 최종 우승했습니다.");
	}


	private void raceOneTime(List<Car> cars) {
		for (Car car : cars) {
			GameNumber gameNumber = new GameNumber();
			goForward(car);
			ioUtils.output(car.getName() + " : " + makeLocationStr(car.getLocation()));
		}
	}

	private void goForward(Car car) {
		GameNumber gameNumber = new GameNumber();
		if (gameRule.isGoForward(gameNumber.getNumber())) {
			car.go();
		}
	}

	private String makeLocationStr(int location) {
		String result = "";
		for (int i = 0; i <= location; i++) {
			result += "-";
		}
		return result;
	}
}
