package racinggame.dto;

import java.util.List;

import racinggame.dto.constant.RacingGameStatusConstant;
import racinggame.model.RacingCar;

public class RacingGameResultDto {
	private RacingGameStatusConstant code;
	private List<RacingCar> racingCarList;
	
	public RacingGameStatusConstant getCode() {
		return code;
	}
	public void setCode(RacingGameStatusConstant code) {
		this.code = code;
	}
	public List<RacingCar> getRacingCarList() {
		return racingCarList;
	}
	public void setRacingCarList(List<RacingCar> racingCarList) {
		this.racingCarList = racingCarList;
	}
}
