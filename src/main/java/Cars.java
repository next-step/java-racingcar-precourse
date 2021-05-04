import java.util.ArrayList;
import java.util.List;

import utils.RandomUtils;
import utils.Validator;

public class Cars {

	private List<Car> cars = new ArrayList<>();
	private int max = 0;

	Cars(String carNameUserInput) {
		if (!Validator.isValidCarNameUserInput(carNameUserInput)) {
			throw new IllegalArgumentException("자동차 이름이 잘못 입력되었습니다. :" + carNameUserInput);
		}

		String[] carNames = carNameUserInput.split(",");
		for (String carName : carNames) {
			cars.add(new Car(carName));
		}
	}

	public void setMax() {
		for (Car car : cars) {
			int position = car.getPosition();
			this.max = Math.max(this.max, position);
		}
	}

	public void playRacingGame() {
		for (Car car : cars) {
			int randomNumber = RandomUtils.getOneDigitRandomNumber();
			car.move(randomNumber);
		}
	}

	public void showCurrentStatus() {
		StringBuilder sb = new StringBuilder();
		for (Car car : cars) {
			sb.append(car.getName()).append(" : ").append(car.getPositionString());
			sb.append(System.lineSeparator());
		}
		System.out.println(sb.toString());
	}

	public void showWinners() {
		StringBuilder sb = new StringBuilder();
		boolean hasOneWinnerOnly = true;
		sb.append(getWinnerList());
		for (Car car : cars) {
			if (this.max < car.getPosition()) {
				continue;
			}

			if (!hasOneWinnerOnly) {
				sb.append(", ");
			}

			sb.append(car.getName());
			hasOneWinnerOnly = false;
		}
		sb.append("가 최종 우승했습니다.");

		System.out.println(sb.toString());
	}

	private String getWinnerList() {
		List<String> winners = new ArrayList<>();
		for (Car car : cars) {
			if (this.max == car.getPosition()) {
				winners.add(car.getName());
			}
		}
		return winners.toString();
	}
}
