package racingcar.io;

import racingcar.domain.cars.Cars;
import racingcar.domain.cars.WinnerCars;

public interface GamePrinter {
    void printCarNameInfo();
    void printCountInfo();
    void printRoundResultPrefix();
    void printRoundResult(Cars cars);
    void printWinner(WinnerCars winnerCars);
}
