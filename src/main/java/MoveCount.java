public class MoveCount {
	private int count;

	MoveCount(int count) {
		this.count = count;
	}

	public int get() {
		return this.count;
	}

	void plus() {
		this.count++;
	}
}
