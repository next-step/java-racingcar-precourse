package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

import nextstep.utils.Randoms;
import racinggame.common.ErrorMessage;

public class Racing {

	public static final int GO_VALUE = 4;
	public static final int MIN_RANGE = 0;
	public static final int MAX_RANGE = 9;
	public static final String DELIMITER = ",";
	List<Car> carList;
	List<String> winnerList;

	public Racing() {
		carList = new ArrayList<>();
		winnerList = new ArrayList<>();
	}

	public void add(Car car) {
		carList.add(car);
	}

	public List<Car> getCarList() {
		return carList;
	}

	public List<String> getWinnerList() {
		return winnerList;
	}

	public boolean isGo(int value) {
		checkValue(value);
		return value >= GO_VALUE;
	}

	private void checkValue(int value) {
		if (value < 0 || value > 9) {
			throw new IllegalArgumentException(ErrorMessage.ERROR_GO_INPUT);
		}
	}

	public void race(Car car, int value) {
		if (isGo(value)) {
			car.go();
		}
	}

	public void start() {
		for (Car car : carList) {
			int random = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
			race(car, random);
		}
	}

	public String getWinner() {
		int maxDistance = getMaxDistance();
		for (Car car : carList) {
			addWinnerList(maxDistance, car);
		}
		return String.join(DELIMITER, winnerList);
	}

	public void addWinnerList(int max, Car car) {
		if (car.getDistance() == max) {
			winnerList.add(car.getName());
		}
	}

	public int getMaxDistance() {
		int maxDistance = 0;
		for (Car car : carList) {
			int curDistance = car.getDistance();
			maxDistance = Math.max(curDistance,maxDistance) ;
		}
		return maxDistance;
	}
}
