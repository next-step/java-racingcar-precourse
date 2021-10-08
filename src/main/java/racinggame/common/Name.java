package racinggame.common;

import racinggame.exception.InvalidNameException;

public class Name {
	private final String name;

	public Name(String name) {
		validateName(name);
		this.name = name;
	}

	private void validateName(String name) {
		int length = name.length();
		if (length <= 0 || length > 5) {
			throw new InvalidNameException("[ERROR] 이름을 1자 이상 5자 이하로 입력하세요");
		}
	}

	public String valueOf (){
		return name;
	}
}
