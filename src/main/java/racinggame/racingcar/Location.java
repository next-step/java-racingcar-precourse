package racinggame.racingcar;

import static racinggame.racingcar.Racing.*;

import java.util.Objects;

public class Location {
	private int location;

	public Location(int location) {
		this.location = location;
	}

	/**
	 * 새로운 위치를 반환한다.
	 *
	 * @return {@link Location}
	 */
	public Location forward() {
		return new Location(location + FORWARD.movable());
	}

	public int valueOf() {
		return location;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Location location1 = (Location)o;
		return location == location1.location;
	}

	@Override
	public int hashCode() {
		return Objects.hash(location);
	}
}
