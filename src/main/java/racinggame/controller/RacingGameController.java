package racinggame.controller;

import java.util.List;

import racinggame.dto.InitRacingGameDto;
import racinggame.model.RacingCar;
import racinggame.model.RacingGame;
import racinggame.util.RacingCarUtil;

public class RacingGameController {
	private RacingGame racingGame;
	
	public void InitRacingGame(InitRacingGameDto initRacingGame) {
		List<RacingCar> racingCarList = RacingCarUtil.createRacingCars(initRacingGame.getCarNamesStr());
		racingGame = new RacingGame(initRacingGame.getRunNumber(), racingCarList);		
	}
}
