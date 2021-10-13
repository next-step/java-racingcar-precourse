package racinggame.model;

import java.util.ArrayList;
import java.util.List;

import nextstep.utils.Randoms;
import racinggame.model.constant.RacingCarConstant;

public class RacingCarList {
	private List<RacingCar> racingCarList;
	
	public RacingCarList(List<RacingCar> racingCarList) {
		this.racingCarList = racingCarList;
	}
	
	public void runRacingCarList() {
		for(RacingCar racingCar : racingCarList) {
			runRacingCar(racingCar);
		}
	}
	
	public RacingCarList getRacingGameWinner(){
		List<RacingCar> racingGameWinner = new ArrayList<RacingCar>();
		Integer maxLocation = 0;
		for(RacingCar racingCar : racingCarList) {
			maxLocation = addRacingGameWinner(racingGameWinner, maxLocation, racingCar);
		}
		return new RacingCarList(racingGameWinner);
	}
	
	public List<RacingCar> getRacingCarList() {
		return racingCarList;
	}

	private void runRacingCar(RacingCar racingCar) {
		if(isMoveFront()) {
			racingCar.moveFront();
		}
	}
	
	private Boolean isMoveFront() {
		return Randoms.pickNumberInRange(RacingCarConstant.RUN_RANDOM_MIN, RacingCarConstant.RUN_RANDOM_MAX) >= RacingCarConstant.RUN_MINIMUM_NUMBER;
	}
	
	private Integer addRacingGameWinner(List<RacingCar> racingGameWinner, Integer maxLocation, RacingCar racingCar) {
		if(racingCar.getLocation() < maxLocation) {
			return maxLocation;
		}
		if(racingCar.getLocation() > maxLocation) {
			racingGameWinner.clear();
		}
		racingGameWinner.add(racingCar);
		return racingCar.getLocation();
	}
}
