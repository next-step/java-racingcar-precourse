package racinggame.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import nextstep.utils.Console;
import nextstep.utils.Randoms;

public class Cars {

	private static final int MIN_NUMBER = 0;
	private static final int MAX_NUMBER = 9;
	private static final String SPLIT_KEY_WORD = ",";
	private final List<Car> racers;

	public Cars(List<String> names) {
		this.racers = initializeCarName(names);
	}

	private List<Car> initializeCarName(List<String> names) {
		List<Car> cars = new ArrayList<>();
		for (String name : names) {
			cars.add(new Car(name));
		}
		return cars;
	}

	public int getNumberOfCars() {
		return racers.size();
	}

	public void race() {
		inRace(getRaceCount());
	}

	private void inRace(int count) {
		while (count-- > 0) {
			racing();
		}
	}

	private int getRaceCount() {
		int count;
		do {
			count = stringToInt(Console.readLine());
		} while (count == 0);
		return count;
	}

	private int stringToInt(String inputNumber) {
		int count;
		try {
			count = Integer.parseInt(inputNumber);
		} catch (Exception e) {
			throw new NumberFormatException("0 이상의 숫자를 입력해주시기 바랍니다.");
		}
		return count;
	}

	private void racing() {
		for (Car car : this.racers) {
			car.race(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
		}
	}

}
