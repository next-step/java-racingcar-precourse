package racinggame.view;

import nextstep.utils.Console;
import racinggame.controller.RacingGameController;
import racinggame.dto.InitRacingGameDto;
import racinggame.view.constant.MessageConstant;

public class RacingGameView {
	private RacingGameController racingGameController;
	
	public RacingGameView(RacingGameController racingGameController) {
		this.racingGameController = racingGameController;
	}

	public void start() {
		initRacingGame();
	}
	
	private void initRacingGame() {
		InitRacingGameDto initRacingGame = new InitRacingGameDto();
		inputCarNames(initRacingGame);
		inputRunNumber(initRacingGame);
		racingGameController.InitRacingGame(initRacingGame);
	}
	
	private void inputCarNames(InitRacingGameDto initRacingGame) {
		printMessage(MessageConstant.INPUT_CAR_NAMES_MESSAGE);
		initRacingGame.setCarNamesStr(Console.readLine());
	}

	private void inputRunNumber(InitRacingGameDto initRacingGame) {
		printMessage(MessageConstant.INPUT_RUN_NUMBER_MESSAGE);
		initRacingGame.setRunNumber(Integer.parseInt(Console.readLine()));
	}

	private void printMessage(MessageConstant message) {
		System.out.print(message.getMessage());
	}
}
