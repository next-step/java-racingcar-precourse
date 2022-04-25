package racingcar.domain;

public class Car {
	private Name name;
	private Distance distance;

	public Car(String name) {
		this.name = new Name(name);
		distance = new Distance(0);
	}

	public Car(String name, int position) {
		this.name = new Name(name);
		distance = new Distance(position);
	}

	public void move(int number) {
		distance.move(number);
	}

	public String getName() {
		return name.getName();
	}

	public int getDistance() {
		return distance.getDistance();
	}

	public boolean isLongerThan(int compareDistance) {
		return distance.isLongerThan(compareDistance);
	}

	public boolean isEqualDistance(int compareDistance) {
		return distance.isEqual(compareDistance);
	}
}
