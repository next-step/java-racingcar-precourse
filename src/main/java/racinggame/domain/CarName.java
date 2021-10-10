package racinggame.domain;

public class CarName {

	private static final int MAX_NAME_LENGTH = 5;

	private final String name;

	private CarName(String name) {
		this.name = name;
	}

	private static boolean isValidLength(String name) {
		return name.length() <= MAX_NAME_LENGTH;
	}

	public static CarName of(String name) {
		if (!isValidLength(name)) {
			throw new IllegalArgumentException("[ERROR] 이름은 5자 이하로 입력해주세요");
		}
		return new CarName(name);
	}

	public String getName() {
		return this.name;
	}
}
