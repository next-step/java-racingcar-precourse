package racinggame;

import static racinggame.utils.ExceptionHandler.*;

import racinggame.domain.GameReport;
import racinggame.domain.GameRound;
import racinggame.domain.RacingCarGame;
import racinggame.domain.RacingCarNames;
import racinggame.strategy.MovingStrategy;
import racinggame.strategy.RandomMovingStrategy;
import racinggame.view.ConsoleView;

public class RacingGameController {
	public void run() {
		RacingCarNames names = processException(() ->
			new RacingCarNames(ConsoleView.readRacingCarNames()));
		GameRound round = processException(() ->
			new GameRound(ConsoleView.readGameRound()));

		MovingStrategy strategy = new RandomMovingStrategy();

		ConsoleView.printGameResult();

		RacingCarGame raceGame = new RacingCarGame(names);
		while (round.hasNext()) {
			raceGame.run(strategy);
			ConsoleView.printPosition(raceGame.reportPosition());
		}

		GameReport gameReport = raceGame.report();
		ConsoleView.printWinners(gameReport.reportWinnersNames());
	}
}