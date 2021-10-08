package racinggame.rule;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import racinggame.exception.InvalidNameException;
import racinggame.ui.Rule;

public class RacingRule implements Rule {
	private final String DELIMITER = ",";

	@Override
	public void validateNames(String nameChunk) throws InvalidNameException {
		List<String> names = Arrays.asList(nameChunk.split(DELIMITER));

		checkNameLength(names);
		checkNameDuplication(names);
	}

	private void checkNameLength(List<String> names) {
		names.forEach(name -> this.nameLengthLimits(name));
	}

	private void nameLengthLimits(String name) {
		int length = name.length();
		if (length <= 0 || length > 5) {
			throw new InvalidNameException("[ERROR] 이름을 1자 이상 5자 이하로 입력하세요");
		}
	}

	private void checkNameDuplication(List<String> names) {
		Set<String> nameSet = new HashSet<>(names);

		if (nameSet.size() != names.size()) {
			throw new InvalidNameException("[ERROR] 중복된 이름을 사용할 수 없습니다.");
		}
	}
}
