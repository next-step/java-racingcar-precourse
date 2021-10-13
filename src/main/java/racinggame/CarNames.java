package racinggame;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNames {
	private final List<CarName> names = new ArrayList<>();

	public CarNames(List<CarName> carNames) {
		validateDuplicatedNames(carNames);
		names.addAll(carNames);
	}

	private void validateDuplicatedNames(List<CarName> carNames) {
		Set<CarName> nameSet = new HashSet<>(carNames);

		if (nameSet.size() != carNames.size()) {
			throw new IllegalArgumentException("중복된 이름은 사용할 수 없습니다");
		}
	}

	public List<CarName> getAll() {
		return names;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < names.size() - 1; i++) {
			sb.append(names.get(i)).append(",");
		}
		sb.append(names.get(names.size()-1));

		return sb.toString();
	}
}
