package racinggame;

public class Repeat {
	private boolean repeat;

	private Repeat(boolean repeat) {
		this.repeat = repeat;
	}

	public static Repeat createRepeat() {
		return new Repeat(true);
	}

	public void init() {
		this.repeat = true;
	}

	public boolean isTrue() {
		if (repeat) {
			return true;
		}
		return false;
	}

	public void set(boolean tureOrFalse) {
		this.repeat = tureOrFalse;
	}
}
