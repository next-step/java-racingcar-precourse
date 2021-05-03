package model;

import java.util.Objects;

public class Car {
	public static final int INIT_POSITION = 0;
	private String name;
	private int position;

	public Car(String name) {
		this.name = name;
		this.position = INIT_POSITION;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public void forward() {
		position++;
	}
}
