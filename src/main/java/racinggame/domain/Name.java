package racinggame.domain;

import java.util.Objects;

public class Name {
	private String name;

	public Name(final String name) {
		this.name = name;
	}

	public String getCarName() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Name opponent = (Name)o;
		return name.equals(opponent.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}