package racinggame.domain;

import java.util.HashMap;
import java.util.Map;

public class Record {
	private final Map<String, Integer> recordMap = new HashMap<>();

	public void add(Car car) {
		recordMap.put(car.getName(), car.getDistance().getValue());
	}

	public String awardTo() {
		Integer maxDistance = getMaxDistance();
		StringBuilder sb = new StringBuilder();

		for (String carName : recordMap.keySet()) {
			sb.append(getWinner(carName, maxDistance));
		}

		String winners = sb.toString();
		return String.join(",", winners.split(","));
	}

	private String getWinner(String carName, Integer maxDistance) {
		if (recordMap.get(carName).equals(maxDistance)) {
			return carName + ",";
		}
		return "";
	}

	private Integer getMaxDistance() {
		Integer max = 0;
		for (String carName : recordMap.keySet()) {
			max = updateMax(max, carName);
		}
		return max;
	}

	private Integer updateMax(Integer prevMax, String carName) {
		if (prevMax < recordMap.get(carName)) {
			return recordMap.get(carName);
		}
		return prevMax;
	}
}
