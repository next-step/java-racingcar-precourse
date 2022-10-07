package racingcar.model;

public class Name {

	private String name;

	public Name(final String name) {
		if (name.length() > 5) {
			throw new IllegalArgumentException("[ERROR] 이름은 5글자 이하만 가능합니다."); //todo [ERROR]를 하드코딩 하는게 맘에 안든다.
		}
		this.name = name;
	}

}
