package Controller;

import Model.CarList;
import View.InputView;
import View.ResultView;

import java.util.Arrays;

public class Game {
    private InputView inputView;
    private ResultView resultView;

    public Game(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void play() {
        String[] carNames = inputView.getCarNames();
        int rounds = inputView.getRounds();

        CarList carList = new CarList(Arrays.asList(carNames));

        for (int i = 0; i < rounds; i++) {
            carList.raceOnce();
            resultView.displayRaceStatus(carList.getCars());
        }

        resultView.displayWinners(carList.findWinners());
    }

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        Game game = new Game(inputView, resultView);
        game.play();
    }
}
