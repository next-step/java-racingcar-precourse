package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    PrintMessage printMessage = new PrintMessage();

    public String getFinishPosition() {
        printPlayCountMessage();

        return Console.readLine();
    }

    public String getCarNames() {
        printRequestCarNamesMessage();
        return Console.readLine();
    }

    private void printPlayCountMessage() {
        printMessage.printPlayCountMessage();
    }

    private void printRequestCarNamesMessage() {
        printMessage.printRequestCarNamesMessage();
    }

}
