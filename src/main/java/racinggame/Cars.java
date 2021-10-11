package racinggame;

import java.util.ArrayList;
import java.util.List;

import nextstep.utils.Randoms;

public class Cars {

	private final List<Car> racers;

	public Cars(List<String> names) {
		this.racers = initialize(names);
	}

	private List<Car> initialize(List<String> names) {
		List<Car> cars = new ArrayList<>();
		for(String name : names){
			cars.add(new Car(name));
		}
		return cars;
	}

	public int getNumberOfCars() {
		return racers.size();
	}

}
