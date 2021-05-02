package racingcar;

public class CarName {
	private String name;

	public CarName(String name) {
		validationCarNameLessThan5(name);
		this.name = name;
	}

	private void validationCarNameLessThan5(String name) {
		if (5 < name.length()) {
			throw new IllegalArgumentException("자동차의 이름은 5자 이하만 가능합니다.");
		}
	}

	public String getName() {
		return name;
	}
}
