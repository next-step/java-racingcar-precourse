package controller;

import java.io.IOException;
import model.CarRace;
import view.InputView;
import view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() throws IOException {

        String[] carNames;
        int times;

        while (true) {
            try {
                carNames = inputView.inputCarNames();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                times = inputView.inputTimes();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        CarRace carRace = new CarRace(carNames);

        outputView.printAnnounce();
        for (int i = 0; i < times; i++) {
            carRace.raceOnce();
            outputView.printRace(carRace);
        }
        outputView.printWinner(carRace);
    }
}
