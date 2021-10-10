package racinggame.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import racinggame.domain.boxing.CarName;
import racinggame.domain.boxing.Position;
import racinggame.domain.strategy.Strategy;

public class Cars {

	public List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public List<Car> getCars() {
		return cars;
	}
}
