package racinggame.model;

import java.util.ArrayList;
import java.util.List;

import nextstep.utils.Randoms;

public class Cars {

	private static final int MIN_NUMBER = 0;
	private static final int MAX_NUMBER = 9;
	private final List<Car> cars;
	private Distance maximumTravelDistance;

	public Cars(List<String> names) {
		this.cars = initializeCarName(names);
		this.maximumTravelDistance = new Distance(0);
	}

	private List<Car> initializeCarName(List<String> names) {
		List<Car> racers = new ArrayList<>();
		for (String name : names) {
			racers.add(new Car(name));
		}
		return racers;
	}

	public List<Car> getCars() {
		return this.cars;
	}

	public int getNumberOfCars() {
		return cars.size();
	}

	public void race() {
		for (Car car : this.cars) {
			car.move(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
			measureMaximumTrableDistance(car.getDistance());
		}
	}

	private void measureMaximumTrableDistance(int distance) {
		if (isMaxDistance(distance)) {
			this.maximumTravelDistance = this.maximumTravelDistance.move();
		}
	}

	public boolean isMaxDistance(int distance) {
		return this.maximumTravelDistance.getDistance() < distance;
	}

	public int getMaximumTravelDistance() {
		return maximumTravelDistance.getDistance();
	}

	public List<String> getWinners() {
		List<String> winners = new ArrayList<>();
		for (Car car : this.cars) {
			addWinner(winners, car);
		}
		return winners;
	}

	private void addWinner(List<String> winners, Car car) {
		if (isWinner(car)) {
			winners.add(car.getName());
		}
	}

	private boolean isWinner(Car car) {
		return this.maximumTravelDistance.getDistance() == car.getDistance();
	}

}
