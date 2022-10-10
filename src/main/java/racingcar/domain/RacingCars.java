package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.RacingCarRandom;

public class RacingCars {
	private List<RacingCar> racingCars;

	public RacingCars(String[] carNames) {
		racingCars = new ArrayList<>();
		for (String carName : carNames) {
			racingCars.add(new RacingCar(carName));
		}
	}

	public void play() {
		for (RacingCar car : racingCars) {
			RacingCarRandom carRandom = new RacingCarRandom();
			car.playRacing(carRandom.getRandomNum());
		}
	}

	public String[][] getCurrentLocation() {
		String[][] location = new String[racingCars.size()][2];
		for (int i = 0; i < racingCars.size(); i++) {
			location[i] = createLocation(racingCars.get(i));
		}
		return location;
	}

	private String[] createLocation(RacingCar racingCar) {
		String[] location = {racingCar.getCarName(), String.valueOf(racingCar.getLocation())};
		return location;
	}

	public String[] getWinnerCars() {
		int maxLocation = getMaxLocation();
		List<String> winnerCars = new ArrayList<>();
		for (RacingCar car : racingCars) {
			addWinner(winnerCars, car, maxLocation);
		}
		return winnerCars.toArray(new String[winnerCars.size()]);
	}

	private void addWinner(List<String> winnerCars, RacingCar car, int maxLocation) {
		if(car.getLocation() == maxLocation) {
			winnerCars.add(car.getCarName());
		}
	}

	private int getMaxLocation() {
		int maxLocation = 0;
		for (RacingCar car : racingCars) {
			maxLocation = Math.max(maxLocation, car.getLocation());
		}
		return maxLocation;
	}

}
