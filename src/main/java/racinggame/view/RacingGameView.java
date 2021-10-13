package racinggame.view;

import java.util.List;

import nextstep.utils.Console;
import racinggame.controller.RacingGameController;
import racinggame.dto.InitRacingGameDto;
import racinggame.dto.RacingGameResultDto;
import racinggame.dto.constant.RacingGameStatusConstant;
import racinggame.model.RacingCar;
import racinggame.model.RacingCarList;
import racinggame.util.RacingCarUtil;
import racinggame.view.constant.MessageConstant;

public class RacingGameView {
	private RacingGameController racingGameController;
	
	public RacingGameView(RacingGameController racingGameController) {
		this.racingGameController = racingGameController;
	}

	public void start() {
		RacingGameResultDto racingGameResult;
		do{
			racingGameResult = initRacingGame();
		}while(!racingGameResult.getCode().equals(RacingGameStatusConstant.INITED));
		runRacingGames();
		showGameResult();
	}
	
	private RacingGameResultDto initRacingGame() {
		RacingGameResultDto racingGameResult = new RacingGameResultDto();
		InitRacingGameDto initRacingGame = new InitRacingGameDto();
		try {
			inputInitRacingInfo(initRacingGame);
			racingGameResult = racingGameController.InitRacingGame(initRacingGame);
		}
		catch (IllegalArgumentException e) {
			initRacingGameExceptionProcess(racingGameResult);
		}
		return racingGameResult;
	}
	
	private void runRacingGames() {
		RacingGameResultDto racingGameResult;
		printMessage(MessageConstant.RUN_RACING_GAME_MESSAGE);
		do {
			racingGameResult = runRacingGame();
			printRacingCarList(racingGameResult.getRacingCarList());
		} while(!racingGameResult.getCode().equals(RacingGameStatusConstant.FINISH));
	}
	
	private void showGameResult() {
		RacingGameResultDto racingGameResult = racingGameController.getRacingGameWinner();
		printGameResult(racingGameResult.getRacingCarList());
	}
	
	private RacingGameResultDto runRacingGame() {
		return racingGameController.runRacingGame();
	}
	
	private void inputInitRacingInfo(InitRacingGameDto initRacingGame) {
		inputCarNames(initRacingGame);
		inputRunNumber(initRacingGame);
	}
	
	private void inputCarNames(InitRacingGameDto initRacingGame) {
		printMessage(MessageConstant.INPUT_CAR_NAMES_MESSAGE);
		initRacingGame.setRacingCarList(new RacingCarList(RacingCarUtil.createRacingCars(Console.readLine())));
	}

	private void inputRunNumber(InitRacingGameDto initRacingGame) {
		printMessage(MessageConstant.INPUT_RUN_NUMBER_MESSAGE);
		initRacingGame.setRunNumber(Integer.parseInt(Console.readLine()));
	}
	
	private void initRacingGameExceptionProcess(RacingGameResultDto racingGameResult) {
		racingGameResult.setCode(RacingGameStatusConstant.ERROR);
		printMessage(MessageConstant.INIT_GAME_ERROR_MESSAGE);
	}
	
	private void printRacingCarList(RacingCarList racingCarList) {
		for(RacingCar racingCar : racingCarList.getRacingCarList()) {
			printRacingCar(racingCar);
		}
		System.out.println();
	}

	private void printRacingCar(RacingCar racingCar) {
		System.out.print(racingCar.getRacingCarName().getName() + " : ");
		for(int i = 0; i < racingCar.getLocation(); i++) {
			System.out.print("-");
		}
		System.out.println();
	}
	
	private void printGameResult(RacingCarList racingCarList) {
		String winnerNames = "";
		for(RacingCar racingCar : racingCarList.getRacingCarList()) {
			winnerNames += "," + racingCar.getRacingCarName().getName();
		}
		winnerNames = winnerNames.replaceFirst(",", "");
		System.out.print(String.format("최종 우승자는 %s 입니다.", winnerNames));
	}
	
	private void printMessage(MessageConstant message) {
		System.out.print(message.getMessage());
	}
}
