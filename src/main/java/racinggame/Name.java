package racinggame;

public class Name {
	private final String name;

	public Name(String name) {
		validateLength(name);
		this.name = name;
	}

	public String value() {
		return this.name;
	}

	private void validateLength(String name) {
		if (name.length() < 1 || name.length() > 5) {
			throw new IllegalArgumentException("[ERROR] 이름은 1~5자 사이로만 가능합니다.");
		}
	}

}
