package racinggame.model;

import java.util.ArrayList;
import java.util.List;

import nextstep.utils.Randoms;

public class Cars {

	private static final int MIN_NUMBER = 0;
	private static final int MAX_NUMBER = 9;
	private final List<Car> racers;
	private MaximumTravelDistance maximumTravelDistance;

	public Cars(List<String> names) {
		this.racers = initializeCarName(names);
		this.maximumTravelDistance = new MaximumTravelDistance(0);
	}

	private List<Car> initializeCarName(List<String> names) {
		List<Car> cars = new ArrayList<>();
		for (String name : names) {
			cars.add(new Car(name));
		}
		return cars;
	}

	public int getNumberOfCars() {
		return racers.size();
	}

	public void race() {
		for (Car car : this.racers) {
			car.move(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
			measureMaximumTrableDistance(car.getDistance());
		}
	}

	private void measureMaximumTrableDistance(int distance) {
		if(isMaxDistance(distance)){
			this.maximumTravelDistance = new MaximumTravelDistance(distance);
		}
	}

	private boolean isMaxDistance(int distance) {
		return this.maximumTravelDistance.getMaximumTravelDistance() < distance;
	}
}
