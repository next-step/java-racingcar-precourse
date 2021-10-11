package racinggame.model;

import java.util.Objects;

public class Name {

	private static final String CHECK_EMPTY_OR_NULL_ERROR_MESSAGE = "자동차 이름이 빈값 또는 Null 입니다.";
	private static final String CHECK_LIMIT_LENGTH_ERROR_MESSAGE = "이름의 길이는 최대 5글자 입니다.";
	private static final int LIMIT_LENGTH = 5;

	private final String name;

	public Name(String name) {
		checkEmptyOrNull(name);
		checkLimitLength(name);
		this.name = name;
	}

	private void checkLimitLength(String name) {
		if (name.length() > LIMIT_LENGTH) {
			throw new IllegalArgumentException(CHECK_LIMIT_LENGTH_ERROR_MESSAGE);
		}
	}

	private void checkEmptyOrNull(String name) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException(CHECK_EMPTY_OR_NULL_ERROR_MESSAGE);
		}
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Name name1 = (Name)o;
		return Objects.equals(name, name1.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
