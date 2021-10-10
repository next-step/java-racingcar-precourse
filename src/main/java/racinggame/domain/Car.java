package racinggame.domain;

import racinggame.common.ErrorMessage;

/**
 * @author Lee JungHo
 * @version 1.0
 * @since 1.0
 */
public class Car {

	public static final String CAR_STRING_FORMAT = "%s : %s";
	public static final String DISTANCE_STR = "-";

	private String name;
	private int distance;

	public Car(String name) {
		setName(name);
	}

	public boolean validName(String name) {
		return name != null && name.trim().length() != 0 && name.trim().length() <= 5;
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

	public void stop() {
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
