package com.racingcar;

import java.util.Objects;

public class Location {
	private int value;

	private Location(int value) {
		this.value = value;
	}

	public static Location init() {
		return new Location(0);
	}

	public void increase() {
		this.value++;
	}

	public int getValue() {
		return value;
	}

	public String visualize() {
		String result = "";
		for (int i = 0; i < getValue(); i++) {
			result += "-";
		}

		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Location location = (Location)o;
		return value == location.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}
}
