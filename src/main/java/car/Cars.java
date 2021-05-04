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

	public List<Car> mapCarList(String names) {
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

	public void showCarsIndex() {
		for (int i = 0; i < carList.size(); i++) {
			carList.get(i).showCarIndexStatus();
		}
		System.out.println();
	}

	List<Car> callCarList() {
		return this.carList;
	}

	public int getCarCount() {
		return carCount;
	}

	public String reportRace() {
		String result = "";
		StringBuffer winners = new StringBuffer();
		List<Car> maxCars = new ArrayList<>();
		for (int i = 0; i < carList.size(); i++) {
			Car car = carList.get(i);
			findWinnerCar(maxCars, car);
		}

		for (Car car : maxCars) {
			winners.append(car.getName()).append(",");
		}

		if (winners.length() > 0) {
			result = winners.substring(0, winners.length() - 1);
		}

		return result;
	}

	public void findWinnerCar(List<Car> maxCars, Car car) {

		if (maxCars.isEmpty()) {
			maxCars.add(car);
		}
		Car maxCar = maxCars.get(0);
		if (car.getCarIndex().getIndex() > maxCar.getCarIndex().getIndex()) {
			maxCars.clear();
			maxCars.add(car);
		} else if (car.getCarIndex().getIndex() == maxCar.getCarIndex().getIndex()) {
			maxCars.add(car);
		}
	}
}
