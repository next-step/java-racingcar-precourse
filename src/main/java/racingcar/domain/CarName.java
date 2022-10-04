package racingcar.domain;

import racingcar.constant.ERROR;

public class CarName {


	private final String name;

	public CarName(String name) {
		this.name = name;
	}

	public static CarName of(String name) {
		return new CarName(name);
	}

	public void lengthCheck() {
		if(name.length()>5){
			throw new IllegalArgumentException(ERROR.EXCESS_LENGTH);
		}
	}
	public void emptyNameCheck() {
		if(name.isEmpty()){
			throw new IllegalArgumentException(ERROR.EMPTY_NAME);
		}
	}
}
