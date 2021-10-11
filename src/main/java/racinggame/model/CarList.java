package racinggame.model;

import java.util.ArrayList;
import java.util.List;

public class CarList {

	private ArrayList<String> carList;

	public CarList(List<String> carNameList) {
		carList = new ArrayList<>();
		carList.addAll(carNameList);
	}
}
