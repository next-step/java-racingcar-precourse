package racingcar;

public class CarName {
	private String name;

	public CarName(String name) {
		validationNotBlank(name);
		validationCarNameLessThan5(name);
		this.name = name;
	}

	private void validationNotBlank(String name){
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("공백은 불가능합니다.");
		}
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
