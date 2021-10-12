package racinggame.domain;

import java.util.Objects;

import racinggame.exception.BlankNameException;
import racinggame.exception.OverNameLengthException;
import racinggame.utils.StringUtils;

public class Name {
	private static final int MAX_OF_LENGTH = 5;

	private final String value;

	public Name(String value) {
		checkValueIsNotBlank(value);
		checkValueLength(value);
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	private void checkValueIsNotBlank(String value) {
		if (StringUtils.isBlank(value)) {
			throw new BlankNameException();
		}
	}

	private void checkValueLength(String value) {
		if (value.length() > MAX_OF_LENGTH) {
			throw new OverNameLengthException();
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Name name = (Name)o;
		return Objects.equals(value, name.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public String toString() {
		return "Name{" +
			"value='" + value + '\'' +
			'}';
	}
}
