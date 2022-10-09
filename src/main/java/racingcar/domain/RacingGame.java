package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.utils.InputValidation;

public class RacingGame {
	private List<Car> cars;

	public RacingGame(String inputValue) {
		settingInitalStatus(inputValue);
	}

	private void settingInitalStatus(String inputValue) {
		cars = new ArrayList<>();
		String[] inputString = inputValue.split(",");
		for(String str : inputString) {
			cars.add(new Car(str));
		}
	}

	public String progressOneStep() {
		StringBuilder stringBuilder = new StringBuilder();
		for(Car car : cars) {
			car.progressNextStep();
			stringBuilder.append(car.printStatus());
		}
		return stringBuilder.toString();
	}

	public String printCurrentWinner() {
		StringBuilder stringBuilder = new StringBuilder("최종 우승자 : ");
		int maxScore = findMaxScore();
		List<Car> winnerCars = findMaxScoreCar(maxScore);
		for(Car car : winnerCars) {
			stringBuilder.append(car.getName());
			stringBuilder.append(", ");
		}
		stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
		return stringBuilder.toString();
	}

	private int findMaxScore() {
		int calculateScore = 0;
		for(Car car : cars) {
			calculateScore = Math.max(car.getPlace(), calculateScore);
		}
		return calculateScore;
	}

	private List<Car> findMaxScoreCar(int maxScore) {
		List<Car> maxScoreList = new ArrayList<>();
		for(Car car : cars) {
			if(car.getPlace() == maxScore) {
				maxScoreList.add(car);
			}
		}
		return maxScoreList;
	}

}
