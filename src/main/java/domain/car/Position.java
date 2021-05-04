package domain.car;

public class Position {

	public static final int DEFAULT_VALUE = 1;
	public static final String DEFAULT_UNDER_ERROR_MESSAGE = "기본값 1 보다 작을 수 없습니다.";

	private Integer value;

	public Position(Integer value) {
		validateValue(value);
		this.value = value;
	}

	private void validateValue(Integer value) {
		if(value < DEFAULT_VALUE) {
			throw new IllegalArgumentException(DEFAULT_UNDER_ERROR_MESSAGE);
		}
	}

	public Position() {
		this(DEFAULT_VALUE);
	}

	public Integer getValue() {
		return value;
	}

	public void increment() {
		this.value++;
	}
}
