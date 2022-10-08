package racingcar.domain.car.factor;

public class Distance {
	private int count;

	public Distance(int count) {
		this.count = count;
	}

	public static Distance of(int count){
		return new Distance(count);
	}

	public int getCount() {
		return count;
	}
}
