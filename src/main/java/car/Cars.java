package car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {

	private List<Car> carList;
	private int carCount;

	public Cars(String names) {
		this.carList = mapCarList(names);
		this.carCount = carList.size();
	}

	public static List<Car> mapCarList(String names) {
		List<Car> carList = new ArrayList<>();
		List<String> carNameList = Arrays.asList(names.split(","));
		for (String name : carNameList) {
			carList.add(new Car(name));
		}
		return carList;
	}

	public void race(List<Integer> movePoints) {
		for (int i = 0; i < movePoints.size(); i++) {
			Car car = carList.get(i);
			car.updateMoveIndex(car.move(movePoints.get(i)));
			carList.set(i, car);
		}
	}

	List<Car> callCarList() {
		return this.carList;
	}

	public int getCarCount() {
		return carCount;
	}
}
