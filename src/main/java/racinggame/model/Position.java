package racinggame.model;

public class Position {
	private int position = 0;

	public Position() {
	}

	public void move() {
		position += 1;
	}

	public int getPosition() {
		return position;
	}
}
