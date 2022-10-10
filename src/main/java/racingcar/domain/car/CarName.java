package racingcar.domain.car;

import java.util.Objects;

import racingcar.constant.ERROR;

public class CarName {

	private final String name;

	public CarName(String name) {
		this.name = name;
		lengthCheck();
		emptyNameCheck();
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

	public String name() {
		return name;
	}

	@Override
	public String toString() {
		return "CarName{" +
			"name='" + name + '\'' +
			'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		CarName carName = (CarName)o;
		return Objects.equals(name, carName.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
