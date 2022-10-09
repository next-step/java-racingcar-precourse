package racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.*;

public class Car {

	private static final int MIN_VALUE_BOUNDARY = 0;
	private static final int MAX_VALUE_BOUNDARY = 9;
	private static final int LEAST_PROCESS_NUMBER = 4;

	private String name;
	private int place;

	public Car(String name) {
		changeCarName(name);
		changePlace(0);
	}

	private void changeCarName(String name) {
		this.name = name;
	}

	private void changePlace(int place) {
		this.place = place;
	}

	public void progressNextStep() {
		if(pickNumberInRange(MIN_VALUE_BOUNDARY, MAX_VALUE_BOUNDARY) >= LEAST_PROCESS_NUMBER) {
			changePlace(this.place + 1);
		}
	}

	public String getName() {
		return name;
	}

	public int getPlace() {
		return place;
	}


	public String printStatus() {
		StringBuilder stringBuilder = new StringBuilder(name);
		stringBuilder.append(" : ");
		for(int i = 0; i < place; i++) {
			stringBuilder.append("-");
		}
		stringBuilder.append("\n");
		return stringBuilder.toString();
	}
}
