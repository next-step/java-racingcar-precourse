package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import car.Car;

public class GameUtil {
	private static final int INITIAL_POSITION = 0;
	public static final int RANDOM_NUM_MAX = 9;
	public static final int MOVABLE_MIN_INT = 4;

	public static String[] splitNameByComma(String name) {
		if (name == null) {
			return null;
		}
		return name.split(",");
	}

	public static int generateRandomNum() {
		//return (int)Math.random() * 10;
		return (int)(Math.random() * (RANDOM_NUM_MAX + 1));
	}

	public static boolean isMovable(int num) {
		return num >= MOVABLE_MIN_INT;
	}

	public static List<Car> createCars(String input) {
		if (input == null) {
			return null;
		}
		List<Car> carList = new ArrayList<>();
		String[] strArray = StringUtil.splitNameByComma(input);
		for (int i = 0; i < strArray.length; i++) {
			carList.add(new Car(strArray[i], INITIAL_POSITION));
		}
		return carList;
	}

	private static List<Car> sortCarList(List<Car> carList) {
		Collections.sort(carList, new Comparator<Car>() {
			@Override
			public int compare(Car c1, Car c2) {
				return c2.getPosition() - c1.getPosition();
			}
		});
		return carList;
	}

	public static List<Car> getFirstPositionCarList(List<Car> carList) {
		List<Car> sortedCarList = sortCarList(new ArrayList<>(carList));
		int maxPosition = sortedCarList.get(0).getPosition();
		List<Car> res = new ArrayList<>();
		for (int i = 0; i < sortedCarList.size(); i++) {
			if (maxPosition == sortedCarList.get(i).getPosition()) {
				res.add(sortedCarList.get(i));
			}
		}
		return res;
	}

}
