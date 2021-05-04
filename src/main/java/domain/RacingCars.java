package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RacingCars {
	private final List<RacingCar> cars;

	public RacingCars(String[] cars) {
		this.cars = mapRacingCar(cars);
		validateOverlappedCarName();
		validMinimumCarCount();
	}

	public static boolean isNull(RacingCars racingCars) {
		return racingCars == null;
	}

	public List<RacingCar> get() {
		return this.cars;
	}

	private void validMinimumCarCount() {
		if (this.isNotMinimumCarCount()) {
			throw new IllegalArgumentException("최소 갯수가 맞지 않습니다");
		}
	}

	private void validateOverlappedCarName() {
		if (containOverlappedCar()) {
			throw new IllegalArgumentException("이름이 중복되는 레이싱카가 존재합니다");
		}
	}

	private List<RacingCar> mapRacingCar(String[] carNames) {
		List<RacingCar> cars = new ArrayList<>();
		for (String carName : carNames) {
			cars.add(new RacingCar(carName));
		}
		return cars;
	}

	public boolean isNotMinimumCarCount() {
		return this.cars.size() < 2;
	}

	public boolean containOverlappedCar() {
		return this.cars.size() != new HashSet<RacingCar>(this.cars).size();
	}

	public void moveCars() {
		for (RacingCar racingCar : this.cars) {
			racingCar.move();
		}
	}

	public int maxCount() {
		int currentMaxCount = -1;
		for (RacingCar racingCar : this.get()) {
			currentMaxCount = Math.max(currentMaxCount, racingCar.getPosition().get());
		}
		return currentMaxCount;
	}

	public List<String> getWinners() {
		int maxCount = maxCount();
		List<String> winners = new ArrayList<String>();
		for (RacingCar racingCar : this.cars) {
			addWinner(maxCount, racingCar, winners);
		}
		return winners;
	}

	private void addWinner(int maxCount, RacingCar racingCar, List<String> winners) {
		if (maxCount == racingCar.getPosition().get()) {
			winners.add(racingCar.getRacingCarName().get());
		}
	}
}
