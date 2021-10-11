package racinggame.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @auhor Kim JeongJin <kingroma92@gmail.com>
 * @version 1.0
 * @since 1.0
 * */
public class Cars {
	public List<Car> cars = new ArrayList<Car>();

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

}
