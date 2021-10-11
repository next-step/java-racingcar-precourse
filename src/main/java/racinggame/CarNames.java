package racinggame;

import java.util.Arrays;
import java.util.List;

public class CarNames {
	public static final int NAME_LENGTH = 5;
	private final List<String> nameList;

	public CarNames(String userInput) {
		String[] names = userInput.split(",");
		for (String name : names) {
			validate(name);
		}
		nameList = Arrays.asList(names);
	}

	public List<String> getNames() {
		return nameList;
	}

	private void validate(String name) {
		if (name.length() > NAME_LENGTH) {
			throw new IllegalArgumentException("[ERROR] 이름이 5글자를 초과합니다.");
		}
	}
}
