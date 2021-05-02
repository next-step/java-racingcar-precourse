package racing.car;

import java.util.ArrayList;
import java.util.List;

public class CarNames {
	private static final String DELIMITER = ",";

	private List<CarName> names;

	public CarNames(String namesWithDelimiter) {
		this.names = new ArrayList<>();

		String[] split = namesWithDelimiter.split(DELIMITER);
		for (String name : split) {
			this.names.add(new CarName(name));
		}
	}

	public List<CarName> getNames() {
		return this.names;
	}
}
