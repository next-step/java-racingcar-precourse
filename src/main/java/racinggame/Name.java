package racinggame;

import java.util.NoSuchElementException;

public class Name {

	protected static final String OUT_OF_LENGTH_MESSAGE = "[ERROR] 이름은 5글자 이하만 가능합니다.";
	protected static final String MUST_BE_NOT_EMPTY = "[ERROR] 이름을 입력하세요.";

	private static final int MAX_LEN = 5;
	private final String name;

	public Name(String name) {

		if (name == null || name.isEmpty()) {
			throw new NoSuchElementException(MUST_BE_NOT_EMPTY);
		}

		if (name.length() > MAX_LEN) {
			throw new NoSuchElementException(OUT_OF_LENGTH_MESSAGE);
		}

		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Name other = (Name)obj;
		if (this.name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!this.name.equals(other.name)) {
			return false;
		}
		return true;
	}

}
