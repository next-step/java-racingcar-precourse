package racingcar.domain;

import java.util.Objects;

import org.junit.platform.commons.util.ToStringBuilder;

import racingcar.util.CarsUtils;

public class Name {
	private final String name;

	public Name(String name) {
		if (!CarsUtils.validateCarName(name)) {
			throw new IllegalArgumentException("[ERROR] 자동차 이름은 빈값이 아니며 5자 이하여야 합니다.");
		}
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Name carName = (Name)o;
		return Objects.equals(name, carName.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("name", name)
			.toString();
	}
}
