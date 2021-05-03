package model;

import java.util.Objects;

import exception.InvalidCarNameException;

public class RacingCar {
	private final CarName name;
	private final Mileage mileage;

	public RacingCar(final CarName name) {
		if (name == null)
			throw new InvalidCarNameException("자동차 이름이 입력되지 않았습니다.");
		this.name = name;
		mileage = new Mileage();
	}

	public CarName getName() {
		return name;
	}

	public Mileage getMileage() {
		return mileage;
	}

	public void move(final boolean isEnableMove) {
		if (isEnableMove)
			mileage.addValue();
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass())
			return false;
		if (this == o)
			return true;
		RacingCar racingCar = (RacingCar)o;
		return Objects.equals(getName(), racingCar.getName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getName());
	}
}
