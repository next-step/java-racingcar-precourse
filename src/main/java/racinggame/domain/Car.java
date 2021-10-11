package racinggame.domain;

import static racinggame.common.CommonConstants.*;

import racinggame.common.ErrorMessage;

/**
 * @author Lee JungHo
 * @version 1.0
 * @since 1.0
 */
public class Car {

	private String name;
	private int distance;

	public Car(String name) {
		setName(name);
	}

	public boolean validName(String name) {
		return name != null && name.trim().length() != NAME_MIN_LENGTH && name.trim().length() <= NAME_MAX_LENGTH;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (!validName(name)) {
			throw new IllegalArgumentException(ErrorMessage.ERROR_CAR_INPUT_NAME);
		}
		this.name = name;
	}

	public int getDistance() {
		return distance;
	}

	public void go() {
		distance++;
	}

	public void race(int randomValue) {
		if (randomValue >= GO_VALUE) {
			go();
		}
	}

	@Override
	public String toString() {
		StringBuilder disStr = new StringBuilder();
		for (int i = 0; i < distance; i++) {
			disStr.append(DISTANCE_STR);
		}
		return String.format(CAR_STRING_FORMAT, name, disStr);
	}

}
