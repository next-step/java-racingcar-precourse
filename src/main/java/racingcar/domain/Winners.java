package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {
	private static final CharSequence SEPARATOR = ",";
	private final List<Car> winners;

	public Winners(List<Car> winners) {
		this.winners = winners;
	}

	@Override
	public String toString() {
		List<String> names = new ArrayList<>();
		for (Car winner : winners) {
			names.add(winner.name());
		}
		return String.join(SEPARATOR, names);
	}
}
