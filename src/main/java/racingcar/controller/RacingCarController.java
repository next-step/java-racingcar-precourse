package racingcar.controller;

import racingcar.model.CarNameList;
import racingcar.model.GameResult;
import racingcar.model.RacingCarGame;
import racingcar.model.RoundCount;
import racingcar.view.InputCarName;
import racingcar.view.InputRoundCount;
import racingcar.view.OutputGameResult;

public class RacingCarController {

	public void run() {
		CarNameList carNameList = new InputCarName().read();
		RoundCount roundCount = new InputRoundCount().read();
		RacingCarGame racingCarGame = new RacingCarGame(carNameList, roundCount);
		GameResult gameResult = racingCarGame.play();
		OutputGameResult outputGameResult = new OutputGameResult();
		outputGameResult.print(gameResult);
	}
}
