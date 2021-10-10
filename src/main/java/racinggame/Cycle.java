package racinggame;

public class Cycle {
	private int cycle;

	Cycle(int cycle) {
		this.cycle = cycle;
	}

	public int cycle() {
		return cycle;
	}

	@Override
	public String toString() {
		return "Cycle{" +
			"cycle=" + cycle +
			'}';
	}
}
