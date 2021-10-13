package racinggame;

public class PlayCount {
	private final int count;

	public PlayCount(int count) {
		validateOverMinNo(count);
		this.count = count;
	}

	private void validateOverMinNo(int count) {
		if (count < 1) {
			throw new IllegalArgumentException("시도횟수는 1회 이상이어야 합니다");
		}
	}

	public int get() {
		return count;
	}
}
