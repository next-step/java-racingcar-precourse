package racinggame.domain;

public class Count {
	private final int value;

	private Count(int value) {
		if (value <= 0) {
			throw new IllegalArgumentException("횟수는 1번 이상 입력 해 주세요.");
		}
		this.value = value;
	}

	public static Count of(int value) {
		return new Count((value));
	}

	public int getValue() {
		return value;
	}
}
