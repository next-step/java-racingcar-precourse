package racingcar;

public class Car {
	private final String STATUS_CHAR = "-";

	private final String name;
	private int position;

	public Car(String name) {
		validName(name);
		this.name = name;
		this.position = 0;
	}

	public void run(int number) {
		if (number > 3) {
			this.position += 1;
		}
	}

	public Integer getPosition() {
		return this.position;
	}

	public String getName() {
		return name;
	}

	private void validName(String name) {
		if (name.length() > 5) {
			throw new IllegalArgumentException("[ERROR] 이름은 5자리 이하로만 가능합니다.");
		}
	}

	private String status() {
		String result = "";
		for (int i = 0; i < this.position; i++) {
			result += STATUS_CHAR;
		}
		return result;
	}

	public String gameStatus() {
		return this.name + " : " + status();
	}
}
