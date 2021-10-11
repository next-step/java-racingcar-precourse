package racinggame;

public class Position implements Comparable<Position> {
	private final int x;

	public Position(int initial) {
		this.x = initial;
	}

	public int getX() {
		return x;
	}

	@Override
	public int compareTo(Position o) {
		return this.x - o.getX();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Position position = (Position)o;
		return x == position.x;
	}
}
