package racinggame.domain;

import java.util.Objects;

public class Name {
	private static final int MIN_NAME_LENGTH = 1;
	private static final int MAX_NAME_LENGTH = 5;
	private final String value;

	private Name(String value) {
		this.value = value;
		checkLengthOver();
	}

	public static Name of(String value) {
		return new Name(value);
	}

	private void checkLengthOver() {
		if (value.length() < MIN_NAME_LENGTH || value.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException("이름은 " + MIN_NAME_LENGTH + "자 이상, " + MAX_NAME_LENGTH + "자 이하만 가능합니다.");
		}
	}

	public String getValue() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Name name = (Name) o;
		return Objects.equals(value, name.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}
}
