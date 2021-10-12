package racinggame;

import java.util.Objects;

public class CarDto {
	private final String name;
	private final int position;

	public CarDto(final String name, final int position) {
		this.name = name;
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		CarDto opponent = (CarDto)o;
		return position == opponent.position && name.equals(opponent.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, position);
	}
}
