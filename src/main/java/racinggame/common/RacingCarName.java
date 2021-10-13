package racinggame.common;

import java.util.Objects;

import racinggame.exception.InvalidNameException;

public class RacingCarName {
	private final String name;

	/**
	 * 레이싱카의 이름을 설정한다.
	 * 레이싱카의 이름은 1자 이상, 5자 이하로 설정한다.
	 * @param name
	 * @throws InvalidNameException : 공백을 입력하거나, 지정한 글자수 이상을 입력하면 Exception 이 발생한다.
	 */
	public RacingCarName(String name) {
		validateName(name);
		this.name = name;
	}

	private void validateName(String name) {
		int length = name.length();
		if (length <= 0 || length > 5) {
			throw new InvalidNameException("[ERROR] 이름을 1자 이상 5자 이하로 입력하세요");
		}
	}

	public String valueOf() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		RacingCarName racingCarName1 = (RacingCarName)o;
		return name.equals(racingCarName1.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
