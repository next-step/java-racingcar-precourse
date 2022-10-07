package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Game {

	private List<Car> carList = new ArrayList<>();

	public Game(String input) {
		String[] carNameArr = input.split(",");
		for (String carName : carNameArr) {
			carList.add(new Car(carName.trim(), 0));
		}
	}

	public String toString() {
		String str = "";
		for (Car car : carList) {
			str += car.getName() + " : " + car.getPosition() + "\n";
		}
		return str;
	}
}
