package racingcar;

public class CarDistance {
	private int distance = 0;

	public int getDistance() {
		return distance;
	}

	public void increase() {
		distance++;
	}

	@Override
	public String toString() {
		StringBuilder stringDistance = new StringBuilder();
		for (int i = 0; i < distance; i++) {
			stringDistance.append("-");
		}
		return stringDistance.toString();
	}
}
