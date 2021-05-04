package domain.car;

public class Position {

	public static final int DEFAULT_VALUE = 1;

	private Integer value;

	public Position(Integer value) {
		this.value = value;
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
