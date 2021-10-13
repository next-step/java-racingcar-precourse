package racinggame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import nextstep.utils.Randoms;

public class RacingCars {
	private List<Car> racingCars;
	
	public RacingCars(String input) {
		this.racingCars = mapRacingCars(input.split(","));
	}
	
	private List<Car> mapRacingCars(String[] inputs) {
		List<Car> cars = new ArrayList<>();
		for (int i = 0; i < inputs.length; i++) {
			cars.add(new Car(inputs[i]));
    	}
		return cars;
	}
	
	public void start() {
		racingCars.forEach(car -> {
			applyRacingRule(car);
			car.showStatus();
		});
	}
	
	private void applyRacingRule(Car car) {
		int random = Randoms.pickNumberInRange(0, 9);
		if (random >= 4) {
			car.go();
		}
	}
	
	public String[] getWinners() {
		List<String> winners = new ArrayList<>();
		Collections.sort(racingCars);
    	int winnerStep = racingCars.get(0).getStep();
    	for (Car car : racingCars) {
    		if (car.isWinner(winnerStep)) {
    			winners.add(car.getName());
    			continue;
    		}
    		break;
    	}
    	return winners.toArray(new String[winners.size()]);
	}
}
