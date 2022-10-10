package racingcar.ui;

import java.util.List;

public interface Output {

    void printResultNotice();

    void printMovingResults(String carsMovingResults);

    void printWinners(List<String> names);

    void printError(String error);
}
