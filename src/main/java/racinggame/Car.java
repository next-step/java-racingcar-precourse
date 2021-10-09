package racinggame;

public class Car {

	private Name name;
	private Position position;

	public Car(String name) {
		this.name = new Name(name);
		this.position = new Position();
	}

	public void move(Strategy generator) {
		position.move(generator);
	}

	public void printCurrentStatus() {
		System.out.println(String.format("%s : %s", getName(), getRoadShape()));
	}

	private String getRoadShape() {
		return position.getRoadShape();
	}

	public String getName() {
		return name.getName();
	}

	public boolean isWinner(Position farthestPosition) {
		return this.position.equals(farthestPosition);
	}

	public Position getFarthestPosition(Position position) {

		if (this.position.equals(position)) {
			return this.position;
		}

		if (this.position.farAwayThan(position)) {
			return this.position;
		}

		return position;
	}

}
