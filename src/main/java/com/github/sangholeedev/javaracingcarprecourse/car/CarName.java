package com.github.sangholeedev.javaracingcarprecourse.car;

public class CarName {
	private final String name;

	public CarName(String name) {
		if(name.length() >= 5) {
			throw new IllegalArgumentException("이름이 5자가 넘습니다.");
		}
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
