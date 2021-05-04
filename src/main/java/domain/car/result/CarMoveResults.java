package domain.car.result;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import domain.car.Position;

public class CarMoveResults {
	
	private final List<CarMoveResult> carMoveResults = new ArrayList<>();

	public void addCarMoveResult(CarMoveResult result) {
		this.carMoveResults.add(result);
	}

	public List<CarMoveResult> getCarMoveResults() {
		return Collections.unmodifiableList(carMoveResults);
	}

	public List<CarMoveResult> getMaxPositionCar() {
		List<CarMoveResult> result = new ArrayList<>();
		Position maxPosition = getMaxPosition();

		for (CarMoveResult carMoveResult : this.carMoveResults) {
			addCarMoveResultIfSamePosition(result, carMoveResult, maxPosition);
		}

		return result;
	}

	private Position getMaxPosition(){
		List<CarMoveResult> copyResults = new ArrayList<>(carMoveResults);
		copyResults.sort(Comparator.comparing(CarMoveResult::getPosition).reversed());
		return copyResults.get(0).getPosition();
	}

	private void addCarMoveResultIfSamePosition(List<CarMoveResult> result, CarMoveResult carMoveResult, Position position) {
		if(carMoveResult.getPosition().equals(position)) {
			result.add(carMoveResult);
		}
	}
}
