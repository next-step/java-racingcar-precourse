package racinggame.domain;

public class Name {

	private static final int MAX_NAME_LENGTH = 5;

	private final String value;

	private Name(String value) {
		this.value = value;
	}

	private static boolean isValidLength(String value) {
		return value.length() <= MAX_NAME_LENGTH;
	}

	public static Name of(String value) {
		if (!isValidLength(value)) {
			throw new IllegalArgumentException("[ERROR] 이름은 5자 이하로 입력해주세요");
		}
		return new Name(value);
	}

	public String getValue() {
		return this.value;
	}
}
