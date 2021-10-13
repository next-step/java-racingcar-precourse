package racinggame.domain;

import java.util.Objects;

public class RacingCarDto {
	private final String name;
	private final int position;

	public RacingCarDto(final String name, final int position) {
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
		RacingCarDto opponent = (RacingCarDto)o;
		return position == opponent.position && name.equals(opponent.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, position);
	}
}