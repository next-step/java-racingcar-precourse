package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarNameList {
	private static final String COMMA = ",";
	private static final String EMPTY = "";

	private final List<CarName> list;

	private CarNameList(String input) {
		String trimmedInput = input.trim();
		validate(trimmedInput);
		this.list = convertCarNameList(trimmedInput);
	}

	public static CarNameList from(String input) {
		return new CarNameList(input);
	}

	private List<CarName> convertCarNameList(String trimmedInput) {
		List<CarName> list = new ArrayList<>();
		for (String carName : trimmedInput.split(COMMA)) {
			list.add(CarName.from(carName));
		}
		return list;
	}

	private void validate(String trimmedInput) {
		if (trimmedInput.isEmpty()) {
			throw new IllegalArgumentException("경주할 자동차 이름을 입력해 주세요.");
		}
		if (trimmedInput.replace(COMMA, EMPTY).isEmpty()) {
			throw new IllegalArgumentException("경주할 자동차 이름을 입력해 주세요.");
		}
	}

	public List<CarName> getList() {
		return Collections.unmodifiableList(list);
	}
}
