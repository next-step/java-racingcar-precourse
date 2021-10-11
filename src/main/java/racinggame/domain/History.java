package racinggame.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class History {
	private final Map<Name, Distance> history;

	private History(Map<Name, Distance> history) {
		this.history = history;
	}

	public static History of(Game game) {
		Map<Name, Distance> history = new LinkedHashMap<>();
		for (Car car : game.getCars()) {
			history.put(car.getName(), Distance.of(car.getDistance().getLength()));
		}
		return new History(history);
	}

	public Set<Name> keySet() {
		return history.keySet();
	}

	public Distance get(Name name) {
		return history.get(name);
	}
}
