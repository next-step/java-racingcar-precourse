package racinggame.racingcar;

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
	public Location forward(Movement movement) {
		return new Location(location + movement.movable());
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
