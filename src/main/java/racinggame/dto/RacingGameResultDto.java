package racinggame.dto;

import java.util.List;

import racinggame.dto.constant.RacingGameStatusConstant;
import racinggame.model.RacingCar;
import racinggame.model.RacingCarList;

public class RacingGameResultDto {
	private RacingGameStatusConstant code;
	private RacingCarList racingCarList;
	
	public RacingGameStatusConstant getCode() {
		return code;
	}
	public void setCode(RacingGameStatusConstant code) {
		this.code = code;
	}
	public RacingCarList getRacingCarList() {
		return racingCarList;
	}
	public void setRacingCarList(RacingCarList racingCarList) {
		this.racingCarList = racingCarList;
	}
}
