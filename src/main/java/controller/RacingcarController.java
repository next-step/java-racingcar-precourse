package controller;

import domain.Cars;
import view.EndView;
import view.StartView;

import java.util.List;

public class RacingcarController {
    private final StartView startView;
    private final EndView endView;

    public RacingcarController(StartView startView, EndView endView) {
        this.startView = startView;
        this.endView = endView;
    }

    public void run() {
        Cars cars = new Cars(startView.readCarNames());
        int count = startView.readTryCount();

        for (int i = 0; i < count; i++) {
            play(cars);
        }
        complete(cars);
    }

    public void startGame() {
        boolean playAgain = true;
        while (playAgain) {
            run();
            playAgain = askToPlayAgain();
        }
        System.out.println("게임 종료");
    }

    private boolean askToPlayAgain() {
        return startView.askToPlayAgain();
    }

    private void play(Cars cars) {
        cars.moveCars();
        endView.printResult(cars);
    }

    private void complete(Cars cars) {
        List<String> winners = cars.selectWinners();
        endView.printWinners(winners);
    }
}