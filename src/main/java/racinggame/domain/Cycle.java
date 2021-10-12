package racinggame.domain;

public class Cycle {
	private int cycle;

	private Cycle(int cycle) {
		this.cycle = cycle;
	}

	public static Cycle init(int cycle) {
		return new Cycle(cycle);
	}

	public int value() {
		return cycle;
	}

	public static boolean isMoreThanOne(String readLine) {
		try {
			return Integer.parseInt(readLine) > 0;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Cycle{" + "cycle=" + cycle + '}';
	}
}
