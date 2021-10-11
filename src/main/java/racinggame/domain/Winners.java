package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {
	public static final String DELIMITER = ",";
	List<Car> carList;

	public Winners() {
		this.carList = new ArrayList<>();
	}

	public List<Car> getCarList() {
		return carList;
	}

	public void addWinner(Car car) {
		if (car != null) {
			carList.add(car);
		}
	}

	@Override
	public String toString() {
		List<String> winnersStr = new ArrayList<>();
		for (Car car : carList) {
			winnersStr.add(car.getName());
		}
		return String.join(DELIMITER, winnersStr);
	}
}
