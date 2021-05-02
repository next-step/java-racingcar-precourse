package home.work.racing.wrap;

public class CarName {

	private static final int MAX_NAME_LENGTH = 5;

	private String name;

	public CarName(String name) {
		if (name == null || name.length() == 0 || name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException("이름은 1 ~ " + MAX_NAME_LENGTH + "의 길이만 허용합니다.");
		}
		this.name = name;
	}

}
