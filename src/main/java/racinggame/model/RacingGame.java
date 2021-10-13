package racinggame.model;

import java.util.ArrayList;
import java.util.List;

import nextstep.utils.Randoms;
import racinggame.dto.constant.RacingGameStatusConstant;
import racinggame.model.constant.RacingCarConstant;

public class RacingGame {
	private Integer runNumber; 
	private Integer runCount; 
	private RacingCarList racingCarList;
	private RacingGameStatusConstant racingGameStatus;
	
	public RacingGame(Integer runNumber, RacingCarList racingCarList) {
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
		racingCarList.runRacingCarList();
		setRacingGameStatus();
	}
	
	public RacingCarList getRacingGameWinner(){
		return racingCarList.getRacingGameWinner();
	}
	
	public Integer getRunNumber() {
		return runNumber;
	}

	public Integer getRunCount() {
		return runCount;
	}

	public RacingCarList getRacingCarList() {
		return racingCarList;
	}

	public RacingGameStatusConstant getRacingGameStatus() {
		return racingGameStatus;
	}

	private void setRacingGameStatus() {
		if(runCount < runNumber) {
			racingGameStatus = RacingGameStatusConstant.RUNNING;
		}
		if(runCount == runNumber) {
			racingGameStatus = RacingGameStatusConstant.FINISH;
		}
	}
	

}
