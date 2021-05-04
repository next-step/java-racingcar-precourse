package domain.car.result;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarMoveResults {
	
	private final List<CarMoveResult> carMoveResults = new ArrayList<>();

	public void addCarMoveResult(CarMoveResult result) {
		this.carMoveResults.add(result);
	}

	public List<CarMoveResult> getCarMoveResults() {
		return Collections.unmodifiableList(carMoveResults);
	}
}
