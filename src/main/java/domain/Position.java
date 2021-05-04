package domain;

public class Position {
	private int position;

	Position(int position) {
		this.position = position;
	}

	public int get() {
		return this.position;
	}

	public void plus() {
		this.position++;
	}
}
