package racingcar;

import racingcar.domain.CarGroup;
import racingcar.domain.NumberOfRound;
import racingcar.utils.InputHandler;

import static racingcar.view.InputView.*;
import static racingcar.view.OutputView.*;

public class GameSystem {
    private NumberOfRound numberOfRound;
    private CarGroup carGroup;

    public void gameStart() {
        carGroup = buildCarGroup();
        numberOfRound = getNumberOfRound();
        printResult();
        printFinalWinner();
    }

    private void printFinalWinner() {
        carGroup.setFinalWinner();
        printWinnerList(carGroup);
    }

    private void printResult() {
        printExecutionResultMessage();
        carGroup.startingDrive(numberOfRound.getNumberOfRound());
    }

    private CarGroup buildCarGroup() {
        boolean nonOk = true;
        Runnable action = () -> carGroup = new CarGroup(InputHandler.splitByComma(requestInputCarName()));
        while (nonOk) {
            nonOk = doTryCatch(action);
        }
        return carGroup;
    }

    private NumberOfRound getNumberOfRound() {
        boolean nonOk = true;
        Runnable action = () -> numberOfRound = new NumberOfRound(requestInputNumberOfRound());
        while (nonOk) {
            nonOk = doTryCatch(action);
        }
        return numberOfRound;
    }

    public boolean doTryCatch(Runnable runnable) {
        try {
            runnable.run();
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
}