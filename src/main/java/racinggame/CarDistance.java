package racinggame;

public class CarDistance {
	private int distance;

	public CarDistance(int i) {
		this.distance = i;
	}

	public void update() {
		this.distance++;
	}

	int getDistance() {
		return this.distance;
	}
}
