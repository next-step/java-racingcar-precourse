package racingcar.domain.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyCarInfo implements Component {

	private final List<Component> components;

	public MyCarInfo(List<Component> components) {
		this.components = new ArrayList(components);
	}

	public List<Component> getMoveDistances() {
		return Collections.unmodifiableList(components);
	}

	public Component getMoveDistances(int round) {
		return components.get(round);
	}

	@Override
	public int getDistances() {
		int totalDistance = 0;
		for(Component component : components){
			totalDistance+= component.getDistances();
		}
		return totalDistance;
	}


}
