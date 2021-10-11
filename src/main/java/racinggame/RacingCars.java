package racinggame;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class RacingCars {
	private final List<RacingCar> cars;

	public RacingCars(CarNames carNames) {
		List<RacingCar> cars = new ArrayList<>(carNames.size());
		for (String name : carNames.getNames()) {
			cars.add(new RacingCar(name));
		}
		this.cars = cars;
	}

	public void move() {
		for (RacingCar car : this.cars) {
			car.move();
		}
	}

	@Override
	public String toString() {
		StringJoiner joiner = new StringJoiner("\n");
		for (RacingCar car : cars) {
			joiner.add(car.toString());
		}
		return joiner.toString();
	}

	public Winners winners() {
		RacingCar winner = winnerRacingCar();
		Winners winners = new Winners(winner.getPosition());
		for (RacingCar car : cars) {
			winners.addWinner(car);
		}
		return winners;
	}

	private RacingCar winnerRacingCar() {
		RacingCar winner = cars.get(0);
		for (int i = 1; i < cars.size(); i++) {
			winner = max(winner, cars.get(i));
		}
		return winner;
	}

	private RacingCar max(RacingCar firstCar, RacingCar secondCar) {
		if (firstCar.compareTo(secondCar) >= 0) {
			return firstCar;
		}

		return secondCar;
	}
}
