package racinggame.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Histories implements Iterable<History> {
	private final List<History> histories;

	public Histories() {
		this.histories = new ArrayList<>();
	}

	public void log(Game game) {
		histories.add(History.of(game));
	}

	@Override
	public Iterator<History> iterator() {
		return histories.iterator();
	}
}
