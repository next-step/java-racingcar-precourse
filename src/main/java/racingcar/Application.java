package racingcar;

import racingcar.controller.ConsoleUserInput;
import racingcar.controller.RaceStadium;
import racingcar.controller.UserInput;
import racingcar.view.BasicBillBoard;
import racingcar.view.BillBoard;
import racingcar.view.ConsoleUserOutput;
import racingcar.view.UserOutput;

public class Application {
    public static void main(String[] args) {
        RaceStadium raceCircuit = wireDependencies();
        raceCircuit.go();
    }

    private static RaceStadium wireDependencies() {
        UserInput userInput = new ConsoleUserInput();
        UserOutput userOutput = new ConsoleUserOutput();
        BillBoard billBoard = new BasicBillBoard(userOutput);
        return new RaceStadium(userInput, billBoard);
    }
}
