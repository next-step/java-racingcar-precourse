package racinggame.model;

public class CarDistance {
	private int distance;

	public CarDistance(int i) {
		this.distance = i;
	}

	public void update() {
		this.distance++;
	}

	public int getDistance() {
		return this.distance;
	}
}
