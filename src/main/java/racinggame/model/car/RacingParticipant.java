package racinggame.model.car;

import java.util.List;

public class RacingParticipant {
	private List<Car> cars;

	public RacingParticipant(List<Car> carList){
		this.cars = carList;
	}
	public List<Car> getCars(){
		return this.cars;
	}
}
