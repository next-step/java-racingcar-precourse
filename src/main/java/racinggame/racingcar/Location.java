package racinggame.racingcar;

import java.util.Objects;

public final class Location {
	private int location;

	public Location(final int location) {
		this.location = location;
	}

	/**
	 * 새로운 위치를 반환한다.
	 * {@link Movement} 에 설정한 {@link Movement#movable()} 만큼 이동한다.
	 *
	 * @return {@link Location}
	 */
	public Location forward(final Movement movement) {
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
