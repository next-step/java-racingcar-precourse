package racinggame.rule;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import racinggame.exception.InvalidNameException;
import racinggame.racingcar.Racing;
import racinggame.ui.Rule;

public final class RacingRule implements Rule {
	private final String DELIMITER = ",";
	private final int DICE_MIN = 0;
	private final int DICE_MAX = 9;
	private final int JUDGE_VALUE = 3;

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

	@Override
	public int diceMax() {
		return this.DICE_MAX;
	}

	@Override
	public int diceMin() {
		return this.DICE_MIN;
	}

	@Override
	public Racing drive(int diceValue) {
		if (diceValue >= DICE_MIN && diceValue <= JUDGE_VALUE) {
			return Racing.STOP;
		}
		return Racing.FORWARD;
	}
}
