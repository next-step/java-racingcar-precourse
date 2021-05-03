package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarPosition {
	private int position = 0;
	private List<CarStatus> carStatusList = new ArrayList<>();

	public int getPosition() {
		return position;
	}

	public List<CarStatus> getCarStatusList() {
		return carStatusList;
	}

	public void forwardPosition() {
		this.position++;
	}

	public void saveHistory(CarStatus carstatus) {
		this.carStatusList.add(carstatus);
	}
}
