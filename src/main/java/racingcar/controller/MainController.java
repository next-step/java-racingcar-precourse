package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Game;
import racingcar.domain.RoundCount;
import racingcar.view.MainView;

public class MainController {

    private Game game = null;

    public void start() {
        requestGameInfoForm();
    }

    public void requestGameInfoForm() {
        MainView.gameInfoForm(this);
    }

    public void requestSetGameInfo(Cars cars, RoundCount roundCount){
        game = new Game(cars, roundCount);

        requestPrintResult();
    }

    private void requestPrintResult() {
        MainView.printResultInfo(this);
    }

    public void requestStartRound() {
        if (game.isOver()) {
            requestWinnerList();
            return ;
        }

        MainView.printStatus(this, game.round());
    }

    private void requestWinnerList() {
        MainView.printWinners(game.getWinners());
    }
}
