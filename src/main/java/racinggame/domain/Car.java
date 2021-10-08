package racinggame.domain;

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

	public Car() {

	}

	public void setName(String name) {
		if(!validName(name)) {
			throw new IllegalArgumentException(ErrorMessage.ERROR_CAR_INPUT_NAME);
		}
		this.name = name;
	}

	public boolean validName(String name) {
		if (name != null && name.trim().length() != 0 && name.trim().length() <= 5) {
			return true;
		}
		return false;
	}

	public String getName() {
		return name;
	}

	public int getDistance() {
		return distance;
	}

	public void go() {
		distance++;
	}

	public void stop() {
	}
}
