package domain.car.name;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarNames {

	private static final String REGEX = ",";

	private List<CarName> names = new ArrayList<>();

	public CarNames(String names) {
		String[] carNames = names.split(REGEX);

		for (String carName : carNames) {
			this.names.add(CarName.of(carName));
		}
	}

	public List<CarName> getNames() {
		return Collections.unmodifiableList(names);
	}
}
