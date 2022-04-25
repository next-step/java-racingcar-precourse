package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class ViewController {

    private final InputView inputView;
    private final OutputView outputView;

    public ViewController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public String getCarNames() {
        outputView.printMessageWithNewLine("경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분");
        return inputView.readLine();
    }

    public String getGameCount() {
        outputView.printMessageWithNewLine("시도할 회수는 몇회인가요?");
        return inputView.readLine();
    }

    public void printMessageWithNewLine(String message) {
        outputView.printMessageWithNewLine(message);
    }

    public void printMessage(String message) {
        outputView.printMessage(message);
    }
}
