package racingcar.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Lane {

	private List<Car> cars;

	public Lane(List<Car> cars) {
		super();
		this.cars = cars;
	}

	public Lane() {
		cars = new ArrayList<>();
	}

	public void enter(Car car) {
		cars.add(car);
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	@Override
	public String toString() {
		return cars.toString();
	}
	
	

}
