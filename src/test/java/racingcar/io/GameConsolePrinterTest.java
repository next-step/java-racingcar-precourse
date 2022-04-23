package racingcar.io;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.cars.Cars;
import racingcar.domain.cars.WinnerCars;

class GameConsolePrinterTest {

    GameConsolePrinter gameConsolePrinter = new GameConsolePrinter();

    @DisplayName("gameConsolePrinter::printCarNameInfo 테스트")
    @Test
    void gameConsolePrinter01() {
        gameConsolePrinter.printCarNameInfo();
    }

    @DisplayName("gameConsolePrinter::printCountInfo 테스트")
    @Test
    void gameConsolePrinter02() {
        gameConsolePrinter.printCountInfo();
    }

    @DisplayName("gameConsolePrinter::printRoundResultPrefix 테스트")
    @Test
    void gameConsolePrinter03() {
        gameConsolePrinter.printRoundResultPrefix();
    }

    @DisplayName("gameConsolePrinter::printRoundResult 테스트")
    @Test
    void gameConsolePrinter04() {
        Cars cars = makeCars();
        gameConsolePrinter.printRoundResult(cars);
    }

    private Cars makeCars() {
        Cars cars = new Cars();
        cars.add(new Car("car1"));
        cars.add(new Car("car2"));
        return cars;
    }

    @DisplayName("gameConsolePrinter::printWinner 테스트")
    @Test
    void gameConsolePrinter05() {
        Cars cars = makeCars();
        WinnerCars winnerCars = cars.calcWinner();
        gameConsolePrinter.printWinner(winnerCars);
    }
}