package domain.car;

public class MoveCount {

	private final Integer count;

	public MoveCount(Integer count) {
		this.count = count;
	}

	public MoveCount(String count) {
		this.count = Integer.valueOf(count);
	}

	public int getCount() {
		return this.count;
	}
}
