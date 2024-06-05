package controller;

import model.CarGroup;
import view.InputView;
import view.OutputView;

import java.io.IOException;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        try {
            String[] carNames = inputView.inputCarNames();
            int tryCount = inputView.inputTryCount();
            CarGroup carGroup = new CarGroup(carNames, tryCount);

            outputView.printExecutionResultMessage();
            while (!carGroup.isEnded()) {
                carGroup.move();
                outputView.printProgress(carGroup);
            }

            outputView.printResult(carGroup);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
