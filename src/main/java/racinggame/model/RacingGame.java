package racinggame.model;

import java.util.List;

public class RacingGame {
	private Integer runNumber; 
	private List<RacingCar> racingCarList;
	
	public RacingGame(Integer runNumber, List<RacingCar> racingCarList) {
		this.runNumber = runNumber;
		this.racingCarList = racingCarList;
	}
}
