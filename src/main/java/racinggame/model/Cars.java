package racinggame.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import nextstep.utils.Console;
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
			measureMaximumTrableDistance(car.getPosition());
		}
	}

	private void measureMaximumTrableDistance(int position) {
		if(isMaxDistance(position)){
			this.maximumTravelDistance = new MaximumTravelDistance(position);
		}
	}

	private boolean isMaxDistance(int position) {
		return this.maximumTravelDistance.getMaximumTravelDistance() < position;
	}
}
