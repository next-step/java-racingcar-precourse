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

	public int forward(int condition) {
		if (condition < 0 || 9 < condition) {
			throw new IllegalArgumentException("전진하는 조건은 0에서 9 사이의 값이어야 합니다.");
		}

		return 0;
	}
}
