package domain;

import java.util.List;

import domain.car.Game;
import domain.car.MoveCount;
import domain.car.name.CarNames;
import domain.car.result.CarMoveResults;
import domain.car.winner.Winners;
import view.InputView;
import view.OutputView;

public class Application {

	public static void main(String[] args) {
		InputView inputView = new InputView(System.in);

		CarNames names = inputView.carNames();
		MoveCount moveCount = inputView.inputCount();

		Game game = new Game(names);

		game.start(moveCount);

		Winners winners = game.getWinners();
		List<CarMoveResults> allResult = game.getAllResult();

		OutputView.printAllResult(allResult);
		OutputView.printWinners(winners);
	}

}
