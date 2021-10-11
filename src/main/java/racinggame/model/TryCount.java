package racinggame.model;

public class TryCount {

	private int count;

	public TryCount(int count) {
		this.count = count;
	}

	public int getCount() {
		return count;
	}

	public void decreaseCount() {
		if (count > 0) {
			count--;
		}
	}

	public boolean isZeroCount() {
		return count == 0;
	}
}
