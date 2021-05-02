package home.work.racing.plural;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import home.work.racing.wrap.CarName;

public class CarNames {
	
	private final List<CarName> names = new ArrayList<>();

	public void addCarName(CarName name) {
		this.names.add(name);
	}
	
	public List<CarName> getNames() {
		return Collections.unmodifiableList(this.names);
	}

}
