package racingcar;

public class CarName {
	private static final int MAX_NAME_LENGTH = 5;

	private String name;

	public CarName(String name) {
		validateNameIsNotBlank(name);
		validateCarNameLengthIsLessThan5(name);
		this.name = name;
	}

	private void validateNameIsNotBlank(String name) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("자동차 이름에 공백은 불가능합니다.");
		}
	}

	private void validateCarNameLengthIsLessThan5(String name) {
		if (MAX_NAME_LENGTH < name.length()) {
			throw new IllegalArgumentException("자동차의 이름은 5자 이하만 가능합니다.");
		}
	}

	public String getName() {
		return name;
	}
}
