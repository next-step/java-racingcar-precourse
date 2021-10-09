package racinggame;

public class Position {

	protected int position;

	public void move(Generator generator) {
		if (generator.canMove()) {
			this.position++;
		}
	}

	public int getPosition() {
		return position;
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
