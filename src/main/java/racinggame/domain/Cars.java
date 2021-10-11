package racinggame.domain;

import static racinggame.common.CommonConstants.*;

import java.util.ArrayList;
import java.util.List;

import nextstep.utils.Randoms;

public class Cars {

	List<Car> carList;

	public Cars() {
		this.carList = new ArrayList<>();
	}

	public void addCar(Car car) {
		if (car != null) {
			carList.add(car);
		}
	}

	public List<Car> getCarList() {
		return carList;
	}

	public int size() {
		return carList.size();
	}

	public int maxDistance() {
		int maxDistance = 0;
		for (Car car : carList) {
			maxDistance = Math.max(car.getDistance(), maxDistance);
		}
		return maxDistance;
	}

	public void racing() {
		for (Car car : carList) {
			car.race(Randoms.pickNumberInRange(RANDOM_MIN_LENGTH, RANDOM_MAX_LENGTH));
		}
	}

	public String getCurStatus() {
		String result = "";
		for (Car car : carList) {
			result = result + (car + NEW_LINE);
		}
		return result;
	}
}
