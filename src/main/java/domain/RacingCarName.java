package domain;

import java.util.Objects;

import util.StringUtils;

public class RacingCarName {
	private static final Integer MIN_LENGTH = 1;
	private static final Integer MAX_LENGTH = 5;
	private final String name;

	public RacingCarName(String name) {
		this.name = name;
		StringUtils.validateEmptyString(this.name);
		validateNameLength();
	}

	public String get() {
		return this.name;
	}

	private void validateNameLength() {
		if (!isValidNameLength()) {
			throw new IllegalArgumentException(
				String.format("레이싱카의 이름은 길이가 %d 이상 %d 이하 이어야 합니다", MIN_LENGTH, MAX_LENGTH));
		}
	}

	public boolean isValidNameLength() {
		return this.name.length() >= MIN_LENGTH && this.name.length() <= MAX_LENGTH;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		RacingCarName that = (RacingCarName)o;
		return Objects.equals(name, that.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
