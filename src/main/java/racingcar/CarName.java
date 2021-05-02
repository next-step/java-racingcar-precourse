package racingcar;

public class CarName {
	private String name;

	public CarName(String name) {
		if (5 < name.length()) {
			throw new IllegalArgumentException("자동차의 이름은 5자 이하만 가능합니다.");
		}

		this.name = name;
	}

	public String getName() {
		return name;
	}
}
