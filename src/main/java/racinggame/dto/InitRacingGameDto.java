package racinggame.dto;

import racinggame.model.RacingCarList;

public class InitRacingGameDto {
	private Integer runNumber;
	private RacingCarList racingCarList;
	
	public Integer getRunNumber() {
		return runNumber;
	}
	public void setRunNumber(Integer runNumber) {
		this.runNumber = runNumber;
	}
	public RacingCarList getRacingCarList() {
		return racingCarList;
	}
	public void setRacingCarList(RacingCarList racingCarList) {
		this.racingCarList = racingCarList;
	}
}
