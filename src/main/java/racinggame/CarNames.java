package racinggame;

import java.util.ArrayList;
import java.util.List;

public class CarNames {
	private final List<CarName> names = new ArrayList<>();

	public CarNames(List<CarName> carNames) {
		names.addAll(carNames);
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
