package racinggame.controller;

import java.util.ArrayList;
import java.util.List;

import racinggame.domain.Car;
import racinggame.domain.Racing;

public class Host {
	public static final String NEW_LINE = "\n";

	Racing racing;
	int tryCount;

	public Host() {
		racing = new Racing();
	}

	public Racing getRacing() {
		return racing;
	}

	public void setRacingCars(String input) {
		String[] carNames = input.trim().split(",");
		for (String name : carNames) {
			racing.add(new Car(name));
		}
	}

	public void setTryCount(int tryCount) {
		this.tryCount = tryCount;
	}

	public String start() {
		List<String> result = new ArrayList<>();
		for (int i = 0; i < tryCount; i++) {
			racing.startRacing();
			result.add(racing.getRacingResultStr());
		}
		return String.join(NEW_LINE, result);
	}

	public String getWinner() {
		return racing.getWinner();
	}

}
