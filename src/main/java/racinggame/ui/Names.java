package racinggame.ui;

import java.util.ArrayList;
import java.util.List;

import racinggame.exception.InvalidNameException;
import racinggame.common.Name;

public class Names {
	private List<Name> names = new ArrayList<>();

	public void add(Name name) {
		if (names.contains(name)) {
			throw new InvalidNameException("[ERROR] 중복된 이름을 사용할 수 없습니다.");
		}
		names.add(name);
	}

	public List<Name> getNames() {
		return new ArrayList<>(names);
	}
}
