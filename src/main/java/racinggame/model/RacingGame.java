package racinggame.model;

import java.util.ArrayList;
import java.util.List;

import nextstep.utils.Randoms;
import racinggame.dto.constant.RacingGameStatusConstant;
import racinggame.model.constant.RacingCarConstant;

public class RacingGame {
	private Integer runNumber; 
	private Integer runCount; 
	private List<RacingCar> racingCarList;
	private RacingGameStatusConstant racingGameStatus;
	
	public RacingGame(Integer runNumber, List<RacingCar> racingCarList) {
		this.runNumber = runNumber;
		this.runCount = 0;
		this.racingCarList = racingCarList;
		this.racingGameStatus = RacingGameStatusConstant.INITED;
	}
	
	public void runRacingCarList() {
		if(runCount > runNumber) {
			return;
		}
		runCount++;			
		for(RacingCar racingCar : racingCarList) {
			runRacingCar(racingCar);
		}
		setRacingGameStatus();
	}
	
	public List<RacingCar> getRacingGameWinner(){
		List<RacingCar> racingGameWinner = new ArrayList<RacingCar>();
		Integer maxLocation = 0;
		for(RacingCar racingCar : racingCarList) {
			maxLocation = addRacingGameWinner(racingGameWinner, maxLocation, racingCar);
		}
		return racingGameWinner;
	}
	
	public Integer getRunNumber() {
		return runNumber;
	}

	public Integer getRunCount() {
		return runCount;
	}

	public List<RacingCar> getRacingCarList() {
		return racingCarList;
	}

	public RacingGameStatusConstant getRacingGameStatus() {
		return racingGameStatus;
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

	private void setRacingGameStatus() {
		if(runCount < runNumber) {
			racingGameStatus = RacingGameStatusConstant.RUNNING;
		}
		if(runCount == runNumber) {
			racingGameStatus = RacingGameStatusConstant.FINISH;
		}
	}
	
	private void runRacingCar(RacingCar racingCar) {
		if(isMoveFront()) {
			racingCar.moveFront();
		}
	}
	
	private Boolean isMoveFront() {
		return Randoms.pickNumberInRange(RacingCarConstant.RUN_RANDOM_MIN, RacingCarConstant.RUN_RANDOM_MAX) >= RacingCarConstant.RUN_MINIMUM_NUMBER;
	}
}
