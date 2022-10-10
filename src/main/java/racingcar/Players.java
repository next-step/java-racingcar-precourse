package racingcar;

import static java.util.Collections.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class Players {
	private final ArrayList<Car> carList;

	public Players(String carNames) {
		this.carList = generateCar(carNames);
	}

	private ArrayList<Car> generateCar(String carNames) {
		ArrayList<Car> carList = new ArrayList<>();
		for (String name : carNames.split(",")) {
			carList.add(new Car(name));
		}
		return carList;
	}

	public ArrayList<String> getCarNameList() {
		ArrayList<String> nameList = new ArrayList<>();
		for (Car car : this.carList) {
			nameList.add(car.getName());
		}
		return nameList;
	}

	public void run() {
		for (Car car : this.carList) {
			car.run(Randoms.pickNumberInRange(0, 9));
		}
	}

	public String status() {
		String result = "";
		for (Car car : this.carList) {
			result += car.gameStatus() + "\n";
		}
		return result;
	}

	public String getWinner() {
		Map<String, ArrayList<String>> counter = getEachPositionCounter();

		Integer max = findMaxPosition(counter.keySet());

		ArrayList<String> winnerList = counter.get(max.toString());

		String result = "";
		for (int i = 0; i < winnerList.size(); i++) {
			result += winnerList.get(i);
			if (i != winnerList.size() - 1) {
				result += ", ";
			}
		}

		return result;
	}

	private Integer findMaxPosition(Set<String> keySet) {
		ArrayList<Integer> keyList = new ArrayList<>();
		for (String position : keySet) {
			keyList.add(Integer.parseInt(position));
		}
		sort(keyList);
		return keyList.get(keyList.size() - 1);
	}

	private Map<String, ArrayList<String>> getEachPositionCounter() {
		Map<String, ArrayList<String>> counter = new HashMap<>();
		for (Car car : this.carList) {
			try {
				counter.get(car.getPosition().toString()).add(car.getName());
			} catch (NullPointerException e) {
				counter.put(car.getPosition().toString(), new ArrayList<String>());
				counter.get(car.getPosition().toString()).add(car.getName());
			}
		}
		return counter;
	}
}
