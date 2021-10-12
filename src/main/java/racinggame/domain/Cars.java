package racinggame.domain;

import static racinggame.common.CommonConstants.*;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import nextstep.utils.Randoms;

public class Cars {

	List<Car> carList;

	public Cars() {
		this.carList = new ArrayList<>();
	}

	public List<Car> getCarList() {
		return carList;
	}

	public void addCar(Car car) {
		if (car != null) {
			carList.add(car);
		}
	}

	public int size() {
		return carList.size();
	}

	public void racing() {
		for (Car car : carList) {
			car.race(Randoms.pickNumberInRange(RANDOM_MIN_LENGTH, RANDOM_MAX_LENGTH));
		}
	}

	public int maxDistance() {
		int maxDistance = 0;
		for (Car car : carList) {
			maxDistance = Math.max(car.getDistance(), maxDistance);
		}
		return maxDistance;
	}

	public String currentStatusString() {
		StringJoiner joiner = new StringJoiner(NEW_LINE);
		for (Car car : carList) {
			joiner.add(car.toString());
		}
		return joiner.toString();
	}
}
