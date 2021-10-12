package racinggame.racingcar;

import static racinggame.racingcar.Racing.*;

import java.util.Objects;

public class Location {
	private int location = 0;

	public Location(int location) {
		this.location = location;
	}

	public void forward() {
		location += FORWARD.movable();
	}

	public int valueOf (){
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
