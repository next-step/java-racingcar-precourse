package racinggame;

public class Position {

	private static final String ROAD_SHAPE = "-";
	protected int position;

	public void move(Strategy strategy) {
		if (strategy.canMove()) {
			this.position++;
		}
	}

	public String getRoadShape() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < position; i++) {
			sb.append(ROAD_SHAPE);
		}
		return sb.toString();
	}

	public boolean farAwayThan(Position position) {
		return this.position > position.position;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.position;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Position other = (Position)obj;
		if (this.position != other.position) {
			return false;
		}
		return true;
	}

}
