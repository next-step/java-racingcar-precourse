package racingcar;

public class Car {
	private String name;

	public Car(String name) {
		if (5 < name.length()) {
			throw new IllegalArgumentException("자동차의 이름은 5자 이하만 가능합니다.");
		}

		this.name = name;
	}

	public String getName() {
		return name;
	}
}
