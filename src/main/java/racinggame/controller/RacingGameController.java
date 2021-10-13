package racinggame.controller;

import java.util.List;

import racinggame.dto.InitRacingGameDto;
import racinggame.dto.RacingGameResultDto;
import racinggame.model.RacingCar;
import racinggame.model.RacingGame;
import racinggame.util.RacingCarUtil;

public class RacingGameController {
	private RacingGame racingGame;
	
	public void InitRacingGame(InitRacingGameDto initRacingGame) {
		List<RacingCar> racingCarList = RacingCarUtil.createRacingCars(initRacingGame.getCarNamesStr());
		racingGame = new RacingGame(initRacingGame.getRunNumber(), racingCarList);		
	}
	
	public RacingGameResultDto runRacingGame() {
		RacingGameResultDto racingGameResult = new RacingGameResultDto();
		racingGame.runRacingCarList();
		racingGameResult.setRacingCarList(racingGame.getRacingCarList());
		racingGameResult.setCode(racingGame.getRacingGameStatus());
		return racingGameResult;
	}
	
	public RacingGameResultDto getRacingGameWinner() {
		RacingGameResultDto racingGameResult = new RacingGameResultDto();
		racingGameResult.setRacingCarList(racingGame.getRacingGameWinner());
		racingGameResult.setCode(racingGame.getRacingGameStatus());
		return racingGameResult;
	}
}
